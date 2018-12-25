package com.litbo.quality.service;

import com.litbo.quality.bean.SUser;
import com.litbo.quality.bean.YqRole;
import com.litbo.quality.vo.UserInfo;
import com.litbo.quality.vo.UserRole;

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
    public List<UserInfo> getUserYqJcbb(String username, Date baginTime, Date endTime,
                                            Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param user
     */
    public void addUser(SUser user);

    /**
     * 获取规定权限的人员
     * @param roleStatus
     * @return
     */
    public List<UserRole> getUserRoleStatus(String eqId , Integer roleStatus);

    /**
     * 添加
     * @param yqRole
     */
    public void addYqRole(YqRole yqRole);

    /**
     * 删除
     * @param yqRole
     */
    public void deleteYqRole(YqRole yqRole);

}
