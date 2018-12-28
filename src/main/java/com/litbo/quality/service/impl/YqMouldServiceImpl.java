package com.litbo.quality.service.impl;

import com.litbo.quality.bean.YqMould;
import com.litbo.quality.dao.YqMouldDao;
import com.litbo.quality.service.YqMouldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class YqMouldServiceImpl implements YqMouldService {
    @Autowired
    private YqMouldDao mouldDao;
    @Override
    public YqMould selectYqMouldById(String mbId) {
        return mouldDao.selectYqMouldById(mbId);
    }

    @Override
    public int updateYqMould(YqMould yqMould) {
        yqMould.setCreateTime(new Date());
        return mouldDao.updateYqMould(yqMould);
    }
}
