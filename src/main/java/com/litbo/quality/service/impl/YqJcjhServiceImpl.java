package com.litbo.quality.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.YqJcjh;
import com.litbo.quality.dao.YqJcjhDao;
import com.litbo.quality.enums.EnumPlanStatus;
import com.litbo.quality.enums.EnumUserRole;
import com.litbo.quality.service.YqJcjhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class YqJcjhServiceImpl implements YqJcjhService {
    @Autowired
    private YqJcjhDao jcjhDao;
    @Override
    public int insertYqJcjh(YqJcjh yqJcjh) {
        yqJcjh.setCreatTime(new Date());
        yqJcjh.setJcjhStatus(EnumPlanStatus.WAIT_DETECTION.getCode());
        return jcjhDao.insertYqJcjh(yqJcjh);
    }

    @Override
    public PageInfo listYqJcjhWaitDetection(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(jcjhDao.listYqJcjh(userId,EnumPlanStatus.WAIT_DETECTION.getCode(),EnumUserRole.USER_ROLE_JC.getCode()));
    }

    @Override
    public PageInfo listYqJcjhWaitExamine(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return  new PageInfo(jcjhDao.listYqJcjh(userId,EnumPlanStatus.PLAN_FINISH.getCode(),EnumUserRole.USER_ROLE_SH.getCode()));
    }

    @Override
    public int updateYqJcjhStatus(Integer jcjhId, Integer status, String userId) {
        return jcjhDao.updateStatus(jcjhId,status,userId,new Date());
    }
}
