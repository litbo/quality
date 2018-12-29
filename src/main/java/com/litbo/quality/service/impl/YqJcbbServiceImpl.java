package com.litbo.quality.service.impl;

import com.litbo.quality.bean.YqJcbb;
import com.litbo.quality.dao.YqJcbbDao;
import com.litbo.quality.dao.YqJcjhDao;
import com.litbo.quality.enums.EnumApplyStatus;
import com.litbo.quality.enums.EnumPlanStatus;
import com.litbo.quality.service.YqJcbbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class YqJcbbServiceImpl implements YqJcbbService {
    @Autowired
    private YqJcbbDao jcbbDao;
    @Autowired
    private YqJcjhDao jcjhDao;
    @Override
    @Transactional
    public int insertYqJcbb(YqJcbb yqJcbb) {
        try {
            yqJcbb.setJcbbShStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());
            jcjhDao.updateStatus(yqJcbb.getEqId(),EnumPlanStatus.WAIT_EXAMINE.getCode());
            return jcbbDao.insertYqJcbb(yqJcbb);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

}
