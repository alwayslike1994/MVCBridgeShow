package com.yyx;

import com.yyx.bean.FlowBean;
import com.yyx.bean.QueryBean;

import java.util.List;

/**
 * Created by alwayslike on 2017/11/29.
 */
public interface FindDaoIf {
    public void insert(FlowBean flowBean);
    public  void deleteByDate(QueryBean queryBean);
    public void update(QueryBean queryBean);
    public FlowBean findOne(QueryBean queryBean);
    public List<FlowBean>find(QueryBean queryBean);
}
