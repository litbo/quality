package com.litbo.quality.dao.provider;

import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

/**
 * @author zjc
 * @create 2018-12-24 17:00
 */
public class YqJcbbProvider {

    public String getYqJcbbCount(String userId, Date beginTime, Date endTime){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM("yq_jcbb");
                if(StringUtils.isNotBlank(userId)){
                    WHERE("jcbb_jcr_id = #{userId}");
                }
                if(beginTime != null){
                    WHERE("jcbb_create_time >= #{beginTime}");
                }
                if(endTime != null){
                    WHERE("jcbb_create_time <= #{endTime}");
                }

            }
        }.toString();
    }
}
