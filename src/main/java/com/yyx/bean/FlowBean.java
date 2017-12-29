package com.yyx.bean;

/**
 * Created by alwayslike on 2017/11/30.
 */
public class FlowBean {

    String date;
    double flow;
    int id;

    public FlowBean() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFlow() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FlowBean(String date, double flow, int id) {
        this.date = date;
        this.flow = flow;
        this.id = id;
    }
}
