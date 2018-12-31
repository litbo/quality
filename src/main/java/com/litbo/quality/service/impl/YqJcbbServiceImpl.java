package com.litbo.quality.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.YqJcbb;
import com.litbo.quality.dao.YqJcbbDao;
import com.litbo.quality.enums.EnumApplyStatus;
import com.litbo.quality.enums.EnumPlanStatus;
import com.litbo.quality.service.YqJcbbService;
import com.litbo.quality.vo.SelectYqJcbbByIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class YqJcbbServiceImpl implements YqJcbbService {
    @Autowired
    private YqJcbbDao jcbbDao;
    @Override
    @Transactional
    public int insertYqJcbb(YqJcbb yqJcbb, String userId) {
        try {
            yqJcbb.setJcbbCreateTime(new Date());
            yqJcbb.setJcbbJcrId(userId);
            yqJcbb.setJcbbShStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());
            return jcbbDao.insertYqJcbb(yqJcbb);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public PageInfo listYqJcbbWaitDeteCtion(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(jcbbDao.listYqJcbb(userId,EnumPlanStatus.WAIT_DETECTION.getCode()));
    }

    @Override
    public int updateYqJcjhStatus(Integer jcbbId, Integer status, String userId, Integer jcjhId) {
        return jcbbDao.updateYqJcjhStatus(jcbbId,status,userId,jcjhId);
    }

    @Override
    public SelectYqJcbbByIdVo selectYqJcbbById(Integer jcbbId) {
        return jcbbDao.selectYqJcbbById(jcbbId);
    }
}
