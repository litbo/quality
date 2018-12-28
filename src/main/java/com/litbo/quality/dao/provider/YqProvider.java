package com.litbo.quality.dao.provider;

import com.github.pagehelper.util.StringUtil;
import com.litbo.quality.bean.Yq;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class YqProvider {
    public String updateYq(Yq yq){
        return new SQL(){
            {
                UPDATE("yq");
                if(StringUtils.isNotBlank(yq.getJcyqName())){
                    SET("jcyq_name = #{jcyqName,jdbcType=VARCHAR}");
                    System.out.println(yq.getJcyqBh());
                }
                if(StringUtils.isNotBlank(yq.getJcyqXh())){
                    SET("jcyq_xh = #{jcyqXh,jdbcType=VARCHAR}");
                }
                if(yq.getJcyqXzzqTime()!=null){
                    SET("jcyq_xzzq_time = #{jcyqXzzqTime,jdbcType=DOUBLE}");
                }
                if(StringUtils.isNotBlank(yq.getJcyqDah())){
                    SET("jcyq_dah = #{jcyqDah,jdbcType=VARCHAR}");
                }
                if(StringUtils.isNotBlank(yq.getJcyqBh())){
                    SET("jcyq_bh = #{jcyqBh,jdbcType=VARCHAR}");
                }
                if(StringUtils.isNotBlank(yq.getJcyqCjId())){
                    SET("jcyq_cj_id = #{jcyqCjId,jdbcType=VARCHAR}");
                }
                if(yq.getJcyqQyTime()!=null){
                    SET("jcyq_qy_time = #{jcyqQyTime,jdbcType=TIMESTAMP}");
                }
                if(StringUtils.isNotBlank(yq.getJcyqKsId())){
                    SET("jcyq_ks_id = #{jcyqKsId,jdbcType=VARCHAR}");
                }
                if(StringUtils.isNotBlank(yq.getJcyqCf())){
                    SET("jcyq_cf = #{jcyqCf,jdbcType=VARCHAR}");
                }
                if(StringUtils.isNotBlank(yq.getJcyqUrl())){
                    SET("jcyq_url = #{jcyqUrl,jdbcType=VARCHAR}");
                }
                if(yq.getJcyqJzTime()!=null){
                    SET(" jcyq_jz_time = #{jcyqJzTime,jdbcType=TIMESTAMP}");
                }
                WHERE("jcyq_id=#{jcyqId}");
            }
        }.toString();
    }
        public String taskYq(){
        return new SQL(){
            {
                SELECT("jcyq_id,jcyq_jz_time,jcyq_name+':日期校准预警' as task ");
                FROM("yq");
                WHERE("datediff(day,jcyq_jz_time,GETDATE()) >= jcyq_xzzq_time");
            }
        }.toString();
    }
}
