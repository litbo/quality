package com.litbo.quality.bean;

import java.util.Date;

public class YqMould {
    private Integer mbId;

    private String jcyqId;

    private Date createTime;

    private Integer mbStatus;

    private String mbText;

    public Integer getMbId() {
        return mbId;
    }

    public void setMbId(Integer mbId) {
        this.mbId = mbId;
    }

    public String getJcyqId() {
        return jcyqId;
    }

    public void setJcyqId(String jcyqId) {
        this.jcyqId = jcyqId == null ? null : jcyqId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getMbStatus() {
        return mbStatus;
    }

    public void setMbStatus(Integer mbStatus) {
        this.mbStatus = mbStatus;
    }

    public String getMbText() {
        return mbText;
    }

    public void setMbText(String mbText) {
        this.mbText = mbText == null ? null : mbText.trim();
    }
}