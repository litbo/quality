package com.litbo.quality.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.SUser;
import com.litbo.quality.bean.YqRole;
import com.litbo.quality.dao.UserDao;
import com.litbo.quality.dao.YqJcbbDao;
import com.litbo.quality.dao.YqRoleDao;
import com.litbo.quality.enums.EnumUserRole;
import com.litbo.quality.service.UserService;
import com.litbo.quality.vo.UserInfo;
import com.litbo.quality.vo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author zjc
 * @create 2018-12-23 17:52
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private YqRoleDao yqRoleDao;

    @Autowired
    private YqJcbbDao yqJcbbDao;


    @Override
    public List<String> userRole(String userId) {
        List<Integer> roles = yqRoleDao.getRole(userId);
        List<String> roleList = new ArrayList<>();
        for (Integer role : roles) {
            if(role == 1){
                roleList.add(EnumUserRole.USER_ROLE_SH.getRole());
            }
            if(role == 2){
                roleList.add(EnumUserRole.USER_ROLE_JC.getRole());
            }
            if(role == 0){
                roleList.add(EnumUserRole.USER_ROLE_ADMIN.getRole());
            }
        }
        return roleList;
    }

    @Override
    public List<String> getRole(String userId) {
        List<Integer> roleStatus = yqRoleDao.getRole(userId);
        List<String> roles = new ArrayList<>();
        for (Integer i : roleStatus) {
            List<String> role = yqRoleDao.getRoles(userId, i);
            roles.addAll(role);
        }
        return roles;
    }

    @Override
    public SUser getUserByUserName(String username) {
        SUser user = userDao.getUserByUserName(username);
        return user;
    }

    @Override
    public UserInfo getUserInfo(String userId) {
        List<Integer> role = yqRoleDao.getRole(userId);
        UserInfo userInfo = new UserInfo();
        if(role != null){
            Map<Integer,List<String>> map = new HashMap();
            for (Integer i : role) {
                List<String> roleEqName = yqRoleDao.getRoleEqName(userId, i);
                map.put(i,roleEqName);
            }
            userInfo.setRoleMap(map);
        }
        SUser user = userDao.getUser(userId);
        userInfo.setSUser(user);
        return userInfo;
    }

    @Override
    public List<UserInfo> getUserInfoList(){
        List<SUser> userList = userDao.getAllUser();
        List<UserInfo> list = new ArrayList();
        for (SUser user : userList) {
            UserInfo userInfo = getUserInfo(user.getUserId());
            list.add(userInfo);
        }
        return list;
    }

    @Override
    public List<UserInfo> getUserYqJcbb(String username, Date baginTime, Date endTime,
                                        Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SUser> userList = userDao.getUserLike(username);
        PageInfo<SUser> pageInfo = new PageInfo<>(userList);
        List<UserInfo> list = new ArrayList();
        for (SUser sUser : pageInfo.getList()) {
            UserInfo userInfo = new UserInfo();
            List<Integer> role = yqRoleDao.getRole(sUser.getUserId());
            if(role.contains(2)){
                List<String> eqName = yqRoleDao.getRoleEqName(sUser.getUserId(), 2);
                userInfo.setSUser(sUser);
                HashMap hashMap = new HashMap();
                hashMap.put(2,eqName);
                userInfo.setRoleMap(hashMap);
                int count = yqJcbbDao.getYqJcbbCount(sUser.getUserId(), baginTime, endTime);
                userInfo.setCount(count);
                list.add(userInfo);
            }
        }
        return list;
    }

    @Override
    public void addUser(SUser user) {
        user.setStatus(1);
        userDao.addUser(user);
    }

    @Override
    public List<UserRole> getUserRoleStatus(String eqId ,Integer roleStatus) {
        List<UserRole> userRoles = userDao.getUserRole(eqId, roleStatus);
        return userRoles;
    }

    @Override
    @Transactional
    public void addYqRole(YqRole yqRole) {
        yqRoleDao.addYqRole(yqRole);
    }

    @Override
    @Transactional
    public void deleteYqRole(YqRole yqRole) {
        yqRoleDao.deleteYqRole(yqRole);
    }


}
