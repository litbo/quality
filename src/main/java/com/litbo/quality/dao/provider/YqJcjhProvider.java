package com.litbo.quality.dao.provider;
import com.litbo.quality.enums.EnumPlanStatus;
import com.litbo.quality.enums.EnumUserRole;
import org.apache.ibatis.jdbc.SQL;

public class YqJcjhProvider {
    public String listYqJcjh(String userId,Integer planStatus,Integer userStatus){
        return new SQL(){
            {
                SELECT("i.eq_name as name,j.creat_time ,j.jcjh_id,j.eq_id");
                FROM("yq_role AS r");
                INNER_JOIN("yq_jcjh AS j ON r.eq_id = j.eq_id and j.jcjh_status =#{planStatus}");
                INNER_JOIN("eq_info as i ON i.eq_id = r.eq_id");
                WHERE("r.user_id = #{userId} " +
                        "AND r.role_status =#{userStatus}");
            }
        }.toString();
    }
}
