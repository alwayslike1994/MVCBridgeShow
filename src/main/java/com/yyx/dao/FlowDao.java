package com.yyx.dao;

import com.yyx.FindDaoIf;
import com.yyx.bean.FlowBean;
import com.yyx.bean.QueryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alwayslike on 2017/11/30.
 */
public class FlowDao implements FindDaoIf {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class FlowMapper implements RowMapper<FlowBean> {
        // TODO Auto-generated method stub
        @Override
        public FlowBean mapRow(ResultSet rs, int rowNum) throws SQLException {
            FlowBean flowBean = new FlowBean();
            flowBean.setId(rs.getInt("id"));
            flowBean.setDate(rs.getString("date"));
            flowBean.setFlow(rs.getInt("flow"));
            return flowBean;
        }
    }

    /**
     * @param flowBean
     */
    @Override
    public void insert(FlowBean flowBean) {
//        String sql=" insert into"+queryBean.getDateType()+"_flow"+" (date,flow) values(?,?)";
//        jdbcTemplate.update(sql,new Object[]{
//                queryBean.getDateType() ,uservo.getPwd()
//        });
    }

    @Override
    public void deleteByDate(QueryBean queryBean) {
        String sql = "delete from " + queryBean.getDateType() + "_flow" + " where date=" + queryBean.getA();
        jdbcTemplate.update(sql);
    }

    @Override
    public void update(QueryBean queryBean) {

    }


    @Override
    public FlowBean findOne(QueryBean queryBean) {
        if (queryBean.getA() != 0) {
            String sql = "select * from" + queryBean.getDateType() + "_flow" +
                    " where date=" + queryBean.getA();
            FlowBean flowBean = jdbcTemplate.queryForObject(sql, new FlowMapper());
            return flowBean;
        } else {
            return null;
        }


    }


    @Override
    public List<FlowBean> find(QueryBean queryBean) {
        if (jdbcTemplate != null) {
            String sql = "select * from " + queryBean.getDateType() + "_flow";
            List<FlowBean> flowBeans = jdbcTemplate.query(sql, new FlowMapper());
            return flowBeans;
        } else {
            return null;
        }

    }


}
