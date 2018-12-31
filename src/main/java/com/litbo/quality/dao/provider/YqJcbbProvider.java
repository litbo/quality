package com.litbo.quality.dao.provider;

import com.litbo.quality.enums.EnumUserRole;
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

    public String listYqJcbb(String userId,Integer status){
        return new SQL(){
            {
                SELECT("b.jcbb_id,e.eq_name as name ,b.eq_id,b.jcbb_create_time as create_time");
                FROM("yq_jcbb AS b");
                INNER_JOIN("yq_role AS r ON r.user_id = #{userId}");
                INNER_JOIN("eq_info as e ON e.eq_id = b.eq_id AND r.role_status = "+EnumUserRole.USER_ROLE_SH.getCode().toString());
                WHERE("b.jcbb_sh_status = #{status} AND r.eq_id = b.eq_id");
            }
        }.toString();
    }
    public String selectYqJcbbById(Integer jcbbId){
        return new SQL(){
            {
                SELECT("j.jcbb_id,j.eq_id,j.data,user_name");
                FROM("yq_jcbb AS j");
                LEFT_OUTER_JOIN("s_user AS u ON u.user_id = j.jcbb_jcr_id");
                WHERE("j.jcbb_id =#{jcbbId}");
            }
        }.toString();
    }

}
