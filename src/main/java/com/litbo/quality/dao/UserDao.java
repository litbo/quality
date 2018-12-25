package com.litbo.quality.dao;

import com.litbo.quality.bean.SUser;
import com.litbo.quality.dao.provider.UserProvider;
import com.litbo.quality.vo.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-23 16:41
 */
@Mapper
public interface UserDao {


    @Select("select * from s_user")
    public List<SUser> getAllUser();

    @Select("select * from s_user where user_id = #{userId}")
    public SUser getUser(String userId);

    @SelectProvider(type = UserProvider.class,method = "getUserLike")
    public List<SUser> getUserLike(String userName);

    @Insert("insert into s_user (user_id, user_name, user_pwd, \n" +
            "      status, bz)\n" +
            "    values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{userPwd,jdbcType=VARCHAR}, \n" +
            "      #{status,jdbcType=INTEGER}, #{bz,jdbcType=LONGVARCHAR})")
    public void addUser(SUser user);

    @Select({
            "<script>",
            "select",
            "*",
            "from s_user",
            "<where>",
                "<if test = ' userIds != null and userIds.size() > 0  '>",
                    " user_id not in",
                    "<foreach collection='userIds' item='id' open='(' separator=',' close=')'>",
                        "#{id}",
                    "</foreach>",
                "</if>",
            "</where>",
            "</script>"
    })
    public List<SUser> getUserByRole(@Param("userIds") List<String> userIds);

    //根据设备及权限查询所有用户并判断是否有检测该设备的权限
    @Select("SELECT u.user_id,u.user_name,s.id from s_user u  " +
            "LEFT  JOIN (SELECT user_id , id from yq_role where role_status = #{roleStatus} and eq_id = #{eqId}) s  " +
            "ON s.user_id = u.user_id")
    public List<UserRole> getUserRole(@Param("eqId") String eqId , @Param("roleStatus") int roleStatus);

    //public List<>

}
