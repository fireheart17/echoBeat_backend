package com.echobeat.model;

public class Chart {

    private long chart_id;
    private String chart_type;

    public Chart() {
    }

    public Chart(long chart_id, String chart_type) {
        this.chart_id = chart_id;
        this.chart_type = chart_type;
    }

    public long getChart_id() {
        return chart_id;
    }

    public void setChart_id(long chart_id) {
        this.chart_id = chart_id;
    }

    public String getChart_type() {
        return chart_type;
    }

    public void setChart_type(String chart_type) {
        this.chart_type = chart_type;
    }
}
