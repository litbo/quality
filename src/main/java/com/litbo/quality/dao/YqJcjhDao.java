package com.litbo.quality.dao;

import com.litbo.quality.bean.YqJcjh;
import com.litbo.quality.dao.provider.YqJcjhProvider;
import com.litbo.quality.vo.ListJcjhByUserId;
import org.apache.ibatis.annotations.*;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

@Mapper
public interface YqJcjhDao {
    @Insert("    insert into yq_jcjh ( eq_id, jcjh_status , fbr_id, creat_time" +
            "      )\n" +
            "    values ( #{eqId}, #{jcjhStatus},#{fbrId},#{creatTime}" +
            "      )")
    int insertYqJcjh(YqJcjh yqJcjh);
    @Update("update yq_jcjh set jcjh_status =  #{jcjhStatus} where eq_id = #{eqId}")
    int updateStatus(@Param("eqId") String eqId, @Param("jcjhStatus") Integer jcjhStatus);
    @SelectProvider(type = YqJcjhProvider.class,method = "listYqJcjh")
    List<ListJcjhByUserId> listYqJcjh(String userId);
}
