package com.litbo.quality.bean;

public class YqJcjh {
    private Integer jcjhId;

    private String eqId;

    private String jcjhStatus;

    public Integer getJcjhId() {
        return jcjhId;
    }

    public void setJcjhId(Integer jcjhId) {
        this.jcjhId = jcjhId;
    }

    public String getEqId() {
        return eqId;
    }

    public void setEqId(String eqId) {
        this.eqId = eqId == null ? null : eqId.trim();
    }

    public String getJcjhStatus() {
        return jcjhStatus;
    }

    public void setJcjhStatus(String jcjhStatus) {
        this.jcjhStatus = jcjhStatus == null ? null : jcjhStatus.trim();
    }
}