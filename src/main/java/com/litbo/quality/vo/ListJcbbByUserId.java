package com.litbo.quality.vo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@lombok.Data
public class ListJcbbByUserId {
    private  String name;
    private  String jcbbId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date creatTime;
    private  String eqId;

}
