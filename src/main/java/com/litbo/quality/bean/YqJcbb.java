package com.litbo.quality.bean;

import java.util.Date;

public class YqJcbb {
    private Integer jcbbId;

    private Date jcbbCreateTime;

    private String jcyqId;

    private String eqId;

    private String jcbbJcrId;

    private String jcbbShrId;

    private Integer jcbbShStatus;

    private String jcbbText;

    public Integer getJcbbId() {
        return jcbbId;
    }

    public void setJcbbId(Integer jcbbId) {
        this.jcbbId = jcbbId;
    }

    public Date getJcbbCreateTime() {
        return jcbbCreateTime;
    }

    public void setJcbbCreateTime(Date jcbbCreateTime) {
        this.jcbbCreateTime = jcbbCreateTime;
    }

    public String getJcyqId() {
        return jcyqId;
    }

    public void setJcyqId(String jcyqId) {
        this.jcyqId = jcyqId == null ? null : jcyqId.trim();
    }

    public String getEqId() {
        return eqId;
    }

    public void setEqId(String eqId) {
        this.eqId = eqId == null ? null : eqId.trim();
    }

    public String getJcbbJcrId() {
        return jcbbJcrId;
    }

    public void setJcbbJcrId(String jcbbJcrId) {
        this.jcbbJcrId = jcbbJcrId == null ? null : jcbbJcrId.trim();
    }

    public String getJcbbShrId() {
        return jcbbShrId;
    }

    public void setJcbbShrId(String jcbbShrId) {
        this.jcbbShrId = jcbbShrId == null ? null : jcbbShrId.trim();
    }

    public Integer getJcbbShStatus() {
        return jcbbShStatus;
    }

    public void setJcbbShStatus(Integer jcbbShStatus) {
        this.jcbbShStatus = jcbbShStatus;
    }

    public String getJcbbText() {
        return jcbbText;
    }

    public void setJcbbText(String jcbbText) {
        this.jcbbText = jcbbText == null ? null : jcbbText.trim();
    }
}