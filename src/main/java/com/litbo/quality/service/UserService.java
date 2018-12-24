package com.litbo.quality.service;

import com.litbo.quality.vo.UserInfo;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-23 17:49
 */
public interface UserService {

    /**
     * 获取用户的信息
     * @param userId
     * @return
     */
    public UserInfo getUserInfo(String userId);


    /**
     * 获取所有用户信息
     * @return
     */
    public List<UserInfo> getUserInfoList();

    /**
     * 获取用户检测工作量
     * @param username
     * @param baginTime
     * @param endTime
     * @return
     */
    public List<UserInfo> getUserYqJcbb(String username, Date baginTime, Date endTime);

}
