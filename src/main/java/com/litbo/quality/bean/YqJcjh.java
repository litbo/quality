package com.litbo.quality.bean;

import lombok.Data;

import java.util.Date;

@Data
public class YqJcjh {
    private Integer jcjhId;

    private String eqId;

    private Integer jcjhStatus;

    private String shrId;

    private String jcrId;//检测人id

    private String fbrId;

    private Date creatTime;

    private Date wcTime;
}