package com.litbo.quality.dao;

import com.litbo.quality.bean.YqJcbb;
import com.litbo.quality.dao.provider.YqJcbbProvider;
import com.litbo.quality.vo.ListJcbbByUserId;
import com.litbo.quality.vo.ListJcjhByUserId;
import com.litbo.quality.vo.SelectYqJcbbByIdVo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

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

    @SelectProvider(type = YqJcbbProvider.class,method = "listYqJcbb")
    List<ListJcbbByUserId> listYqJcbb(@Param("userId") String userId, @Param("status") Integer status);

    @Update("update yq_jcbb set jcbb_sh_status = #{status},jcbb_shr_id = #{userId},jcjh_id=#{jcjhId} where jcbb_id = #{jcbbId}")
    int updateYqJcjhStatus(@Param("jcbbId") Integer jcbbId, @Param("status") Integer status,
                           @Param("userId") String userId, @Param("jcjhId") Integer jcjhId);
    @SelectProvider(type = YqJcbbProvider.class,method = "selectYqJcbbById")
    SelectYqJcbbByIdVo selectYqJcbbById(Integer jcbbId);
}
