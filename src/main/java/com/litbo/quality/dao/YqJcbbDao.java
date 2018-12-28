package com.litbo.quality.dao;

import com.litbo.quality.bean.YqJcbb;
import com.litbo.quality.dao.provider.YqJcbbProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Date;

/**
 * @author zjc
 * @create 2018-12-24 16:49
 */
@Mapper
public interface YqJcbbDao {

    //查询用户工作量
    @SelectProvider(type = YqJcbbProvider.class,method = "getYqJcbbCount")
    int getYqJcbbCount(@Param("userId") String userId, @Param("beginTime") Date beginTime,
                              @Param("endTime") Date endTime);

    @Insert("    insert into yq_jcbb ( data, jcbb_create_time, \n" +
            "      jcyq_id, eq_id, jcbb_jcr_id, \n" +
            "      jcbb_shr_id, jcbb_sh_status)\n" +
            "    values (#{data,jdbcType=VARCHAR}, #{jcbbCreateTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jcyqId,jdbcType=VARCHAR}, #{eqId,jdbcType=VARCHAR}, #{jcbbJcrId,jdbcType=VARCHAR}, \n" +
            "      #{jcbbShrId,jdbcType=VARCHAR}, #{jcbbShStatus,jdbcType=INTEGER})")
    int insertYqJcbb(YqJcbb yqJcbb);
}
