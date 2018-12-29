package com.litbo.quality.dao;

import com.litbo.quality.bean.YqRole;
import com.litbo.quality.dao.provider.YqRolePrvider;
import org.apache.ibatis.annotations.*;

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

    //根据角色以及权限查询所管理的设备名称
    @SelectProvider(type = YqRolePrvider.class,method = "getRoles")
    public List<String> getRoles(@Param("userId") String userId, @Param("roleStatus") int roleStatus);


    //查询用户拥有的权限
    @Select("select distinct role_status from yq_role where user_id = #{userId}")
    public List<Integer> getRole(String userId);

    //查询权限是status的人
    @Select("select user_id from yq_role where role_status == roleStatus")
    public List<String> getYqRole(int roleStatus);

    //查询所有指定设备的检测或审核人员
    @Select("select user_id from yq_role where eq_id = #{eqId} and role_status = #{roleStatus}")
    public List<String> getUserIdsByeqId(String eqId,Integer roleStatus);

    //删除
    @Delete("delete from yq_role where user_id = #{userId} and eq_id = #{eqId} and role_status = #{roleStatus}")
    public void deleteYqRole(YqRole yqRole);

    //添加
    @Insert("insert into yq_role (user_id, role_status, \n" +
            "      eq_id)\n" +
            "    values ( #{userId,jdbcType=VARCHAR}, #{roleStatus,jdbcType=INTEGER}, \n" +
            "      #{eqId,jdbcType=VARCHAR})")
    public void addYqRole(YqRole yqRole);

}
