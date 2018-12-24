package com.litbo.quality.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-23 17:14
 */
@Mapper
public interface YqRoleDao {

    //根据角色以及权限查询所管理的设备
    @Select("select eq_id from yq_role where user_id = #{userId} and role_status = #{roleStatus}")
    public List<String> getRoleEq(@Param("userId") String userId, @Param("roleStatus") int roleStatus);

    //根据角色以及权限查询所管理的设备名称
    @Select("SELECT eq.eq_name FROM dbo.eq_info AS eq ,dbo.yq_role AS role\n" +
            "WHERE eq.eq_id = role.eq_id AND role.role_status = #{roleStatus} AND role.user_id = #{userId}")
    public List<String> getRoleEqName(@Param("userId") String userId, @Param("roleStatus") int roleStatus);

    //查询用户拥有的权限
    @Select("select distinct role_status from yq_role where user_id = #{userId}")
    public List<Integer> getRole(String userId);
}
