package com.litbo.quality.service.impl;

import com.litbo.quality.bean.SUser;
import com.litbo.quality.dao.UserDao;
import com.litbo.quality.dao.YqJcbbDao;
import com.litbo.quality.dao.YqRoleDao;
import com.litbo.quality.service.UserService;
import com.litbo.quality.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UserInfo> getUserYqJcbb(String username, Date baginTime, Date endTime) {
        List<SUser> userList = userDao.getUserLike(username);
        List<UserInfo> list = new ArrayList();
        for (SUser sUser : userList) {
            UserInfo userInfo = new UserInfo();
            List<String> eqName = yqRoleDao.getRoleEqName(sUser.getUserId(), 2);
            userInfo.setSUser(sUser);
            HashMap hashMap = new HashMap();
            hashMap.put(2,eqName);
            userInfo.setRoleMap(hashMap);
            int count = yqJcbbDao.getYqJcbbCount(sUser.getUserId(), baginTime, endTime);
            userInfo.setCount(count);
            list.add(userInfo);
        }
        return list;
    }


}
