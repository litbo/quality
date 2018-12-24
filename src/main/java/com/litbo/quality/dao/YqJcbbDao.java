package com.litbo.quality.dao;

import com.litbo.quality.dao.provider.YqJcbbProvider;
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
    public int getYqJcbbCount(@Param("userId") String userId, @Param("beginTime") Date beginTime,
                              @Param("endTime") Date endTime);


}
