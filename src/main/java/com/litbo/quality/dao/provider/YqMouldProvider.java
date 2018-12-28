package com.litbo.quality.dao.provider;

import com.litbo.quality.bean.Yq;
import com.litbo.quality.bean.YqMould;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class YqMouldProvider {
    public String updateYqMould(YqMould yqMould){
        return new SQL(){
            {
                UPDATE("yq_mould");
                if(yqMould.getCreateTime()!=null){
                    SET(" create_time = #{createTime,jdbcType=TIMESTAMP}");
                }
                if(StringUtils.isNotBlank(yqMould.getData())){
                    SET("data = #{data,jdbcType=VARCHAR}");
                }

                WHERE("mb_id=#{mbId}");
            }
        }.toString();
    }
}
