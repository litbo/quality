package com.litbo.quality.dao;

import com.litbo.quality.bean.YqMould;
import com.litbo.quality.dao.provider.YqMouldProvider;
import com.litbo.quality.dao.provider.YqProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

@Mapper
public interface YqMouldDao {
    @Select("select * from yq_mould where mb_id = #{mbId}")
    YqMould selectYqMouldById(String mbId);
    @UpdateProvider(type = YqMouldProvider.class, method = "updateYqMould")
    int updateYqMould(YqMould yqMould);
    @Select("select mb_id,mb_name from yq_mould")
    List<YqMould> listYqMould();
}
