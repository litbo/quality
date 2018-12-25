package com.litbo.quality.dao;

import com.litbo.quality.vo.YqEqInfo;
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
    public List<YqEqInfo> getYqEq(String eqId);

}
