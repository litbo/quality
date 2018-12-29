package com.litbo.quality.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.YqJcjh;
import com.litbo.quality.dao.YqJcjhDao;
import com.litbo.quality.enums.EnumPlanStatus;
import com.litbo.quality.service.YqJcjhService;
import com.litbo.quality.vo.ListJcjhByUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public PageInfo listYqJcjh(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(jcjhDao.listYqJcjh(userId));
    }
}
