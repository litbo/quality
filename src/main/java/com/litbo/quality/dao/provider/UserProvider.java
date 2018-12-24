package com.litbo.quality.dao.provider;

import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author zjc
 * @create 2018-12-23 16:42
 */
public class UserProvider {

    public String getUser(String userId,String userName){
        return new SQL(){
            {
                SELECT("*");
                FROM("s_user");
                if(StringUtils.isNotBlank(userId)){
                    WHERE("user_id = #{userId}");
                }
                if(StringUtils.isNotBlank(userName)){
                    WHERE("user_name like %#{userName}%");
                }
            }
        }.toString();
    }

}
