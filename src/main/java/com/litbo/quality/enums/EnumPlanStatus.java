package com.litbo.quality.enums;

import lombok.Getter;

public enum EnumPlanStatus {
    WAIT_DETECTION(0,"待检测"),
    WAIT_EXAMINE(1,"待审核"),
    PLAN_FINISH(2,"计划完成"),
    APPLY_REJECT(3,"审核拒绝");
    @Getter
    private Integer code;
    @Getter
    private String message;
    EnumPlanStatus(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
