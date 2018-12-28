package com.litbo.quality.service.impl;

import com.litbo.quality.bean.YqJcbb;
import com.litbo.quality.dao.YqJcbbDao;
import com.litbo.quality.service.YqJcbbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YqJcbbServiceImpl implements YqJcbbService {
    @Autowired
    private YqJcbbDao jcbbDao;
    @Override
    public int insertYqJcbb(YqJcbb yqJcbb) {
        return jcbbDao.insertYqJcbb(yqJcbb);
    }
}
