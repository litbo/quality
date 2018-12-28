package com.litbo.quality.service;

import com.litbo.quality.bean.Yq;
import com.litbo.quality.vo.YqEqInfo;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-25 17:34
 */
public interface YqService {

    /**
     * 检测仪器分配
     * @param eqId
     * @return
     */
    List<YqEqInfo> getYqEqInfoList(String eqId);

    List listYq();

    Yq selectYqById(int jcyqId);

    int insertYq(Yq yq);

    int updateYq(Yq yq);

    List taskYq();
}
