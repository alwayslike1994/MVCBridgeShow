package com.yyx.bean;

/**
 * Created by alwayslike on 2017/11/29.
 */


public class QueryBean {
    String bridge;
    String dateType;
    double a;

    public QueryBean() {
    }

    /**
     *
     * @param bridge
     * @param dateType
     */
    public QueryBean(String bridge, String dateType) {
        this.bridge = bridge;
        this.dateType = dateType;
    }

    /**
     *
     * @param bridge
     * @param dateType
     * @param a
     */
    public QueryBean(String bridge, String dateType, double a) {
        this.bridge = bridge;
        this.dateType = dateType;
        this.a = a;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }
}
