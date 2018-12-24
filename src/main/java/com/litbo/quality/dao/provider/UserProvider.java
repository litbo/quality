package com.litbo.quality.dao.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author zjc
 * @create 2018-12-23 16:42
 */
public class UserProvider {

    public String getUser(String userId){
        return new SQL(){
            {
                SELECT("*");
                FROM("s_user");
                if(userId != null && !"".equals(userId)){
                    WHERE("user_id = #{userId}");
                }
            }
        }.toString();
    }

}
