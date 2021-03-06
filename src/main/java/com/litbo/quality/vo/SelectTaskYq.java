package com.litbo.quality.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SelectTaskYq {
    private String jcyqId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date jcyqJzTime;
    private String task;
}
