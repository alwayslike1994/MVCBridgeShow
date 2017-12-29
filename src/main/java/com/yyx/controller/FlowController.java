package com.yyx.controller;

import com.google.gson.Gson;
import com.yyx.bean.FlowBean;
import com.yyx.bean.QueryBean;
import com.yyx.dao.FlowDao;
import com.yyx.util.ChartUtil;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.AbstractDocument;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by alwayslike on 2017/12/4.
 */
@RestController
public class FlowController {
    private FlowDao dao;

    @Autowired
    public void setDao(FlowDao dao) {
        this.dao = dao;
    }


    @RequestMapping(value = "/AAA/*",method = POST)
    public String query( HttpServletRequest httpServletRequest) {

//        String bridge = queryBean.getBridge();暂时不用这个，以后添加了不同的数据库就要依照bridge选择dao（猜想）；
        StringBuilder builder = new StringBuilder();
        BufferedReader bufferedReader=null;
        String line="";
        try {
            bufferedReader = httpServletRequest.getReader();
            line=bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(line!=null){
            builder.append(line);
        }

        String queryBeanStr=builder.toString();
        System.out.println(queryBeanStr);
        QueryBean  queryBean=new Gson().fromJson(queryBeanStr,QueryBean.class);
        String dateType = queryBean.getDateType();
        String path = httpServletRequest.getServletContext().getRealPath("/");
        Double a = queryBean.getA();
        JFreeChart chart = null;
        List<FlowBean> flowBeans = new ArrayList<>();
        if (dao.find(queryBean) == null) {
            return null;
        } else {
            flowBeans = dao.find(queryBean);
        }
        switch (dateType) {
            case "minute":
                TimeSeries timeSeries2 = new TimeSeries("分访问", Minute.class);
                chart = ChartUtil.doLineChart(flowBeans, timeSeries2, "minute");
                break;
            case "hour":
                TimeSeries timeSeries3 = new TimeSeries("时访问", Hour.class);
                chart = ChartUtil.doLineChart(flowBeans, timeSeries3, "hour");
                break;
            case "day":
                chart = ChartUtil.doPillarChart(flowBeans, dateType);
                break;
            case "year":
                chart = ChartUtil.doPillarChart(flowBeans, dateType);
                break;
        }
        try {
            ChartUtilities.saveChartAsPNG(new File(path + "img\\chart" + a + ".png"), chart, 1680, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path + "img\\chart" + a + ".png";
    }
}
