package com.litbo.quality.enums;

import lombok.Getter;

public enum EnumPlanStatus {
    WAIT_DETECTION(0,"待审核/待完成"),
    PLAN_FINISH(1,"审核通过/已完成"),
    APPLY_REJECT(2,"审核拒绝");
    @Getter
    private Integer code;
    @Getter
    private String message;
    EnumPlanStatus(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
