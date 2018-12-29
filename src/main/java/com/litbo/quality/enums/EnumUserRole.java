package com.litbo.quality.enums;

import lombok.Getter;

/**
 * @author zjc
 * @create 2018-12-29 17:21
 */
public enum EnumUserRole {

    USER_ROLE_ADMIN(0,"超管","admin"),

    USER_ROLE_SH(1,"审核人员","sh"),

    USER_ROLE_JC(2,"检测人员","jc");

    @Getter
    private Integer code;
    @Getter
    private String message;
    @Getter
    private String role;
    EnumUserRole(Integer code,String message,String role){
        this.code = code;
        this.message = message;
        this.role = role;
    }
}
