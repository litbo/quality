package com.litbo.quality.dao.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author zjc
 * @create 2018-12-29 15:23
 */
public class YqRolePrvider {

    public String getRoles(String userId,int roleStatus){
        return new SQL(){
            {
                if(roleStatus == 1){
                    SELECT("'jc' + eq.eq_name as role");
                }
                if(roleStatus == 2){
                    SELECT("'sh' + eq.eq_name as role");
                }
                FROM("eq_info as eq , yq_role AS role");
                WHERE("eq.eq_id = role.eq_id AND role.role_status = #{roleStatus} " +
                        "AND role.user_id = #{userId}");
            }
        }.toString();
    }

}
