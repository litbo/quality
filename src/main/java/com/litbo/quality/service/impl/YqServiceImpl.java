package com.litbo.quality.service.impl;


import com.litbo.quality.dao.YqDao;
import com.litbo.quality.service.YqService;
import com.litbo.quality.vo.SelectTaskYq;
import com.litbo.quality.vo.YqEqInfo;

import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.Yq;
import com.litbo.quality.dao.YqDao;
import com.litbo.quality.service.YqService;
import com.litbo.quality.utils.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-25 17:35
 */
@Service
public class YqServiceImpl implements YqService {

    @Autowired
    private YqDao yqDao;

    @Override
    public List<YqEqInfo> getYqEqInfoList(String eqId) {
        List<YqEqInfo> yqEqInfoList = yqDao.getYqEq(eqId);
        return yqEqInfoList;
    }
    @Override
    public int insertYq(Yq yq){
        return yqDao.insertYq(yq);
    }

    public List listYq(){
        return yqDao.listYq();
    }

    @Override
    public List<SelectTaskYq> taskYq() {
        return yqDao.taskYq();
    }

    @Override
    public Yq selectYqById(int jcyqId) {
        return yqDao.selectYqById(jcyqId);

    }

    @Override
    public int updateYq(Yq yq) {
        return yqDao.updateYq(yq);
    }

}
