package com.litbo.quality.dao;

import com.litbo.quality.bean.SUser;
import com.litbo.quality.dao.provider.UserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-23 16:41
 */
@Mapper
public interface UserDao {


    @SelectProvider(type = UserProvider.class,method = "getUser")
    public List<SUser> getAllUser();

    @SelectProvider(type = UserProvider.class,method = "getUser")
    public SUser getUser(String userId);

    @SelectProvider(type = UserProvider.class,method = "")
    public List<SUser> getUserLike(String userName);

}
