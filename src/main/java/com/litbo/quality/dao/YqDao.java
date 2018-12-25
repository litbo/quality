package com.litbo.quality.dao;


import com.litbo.quality.vo.YqEqInfo;

import com.litbo.quality.bean.Yq;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-25 16:52
 */
@Mapper
public interface YqDao {

    //根据设备号查询所有检测仪器
    @Select("SELECT y.jcyq_id,y.jcyq_name,s.id from yq y " +
            "LEFT JOIN (select * from yq_eq where eq_id = #{eqId}) s " +
            "on s.yq_id = y.jcyq_id")
    List<YqEqInfo> getYqEq(String eqId);

    @Select("select * from yq")
    List listYq();
    @Select("select * from yq where jcbb_id = #{jcbbId}")
    Yq selectYqById(Integer jcbbId);
    @Insert("    insert into yq (jcyq_name, jcyq_xh, \n" +
            "      jcyq_xzzq_time, jcyq_dah, jcyq_bh, \n" +
            "      jcyq_cj_id, jcyq_qy_time, jcyq_ks_id, \n" +
            "      jcyq_cf, jcyq_url, jcyq_jz_time\n" +
            "      )\n" +
            "    values (#{jcyqName,jdbcType=VARCHAR}, #{jcyqXh,jdbcType=VARCHAR}, \n" +
            "      #{jcyqXzzqTime,jdbcType=DOUBLE}, #{jcyqDah,jdbcType=VARCHAR}, #{jcyqBh,jdbcType=VARCHAR}, \n" +
            "      #{jcyqCjId,jdbcType=VARCHAR}, #{jcyqQyTime,jdbcType=TIMESTAMP}, #{jcyqKsId,jdbcType=VARCHAR}, \n" +
            "      #{jcyqCf,jdbcType=VARCHAR}, #{jcyqUrl,jdbcType=VARCHAR}, #{jcyqJzTime,jdbcType=TIMESTAMP}\n" +
            "      )")
    int insertYq(Yq yq);
}