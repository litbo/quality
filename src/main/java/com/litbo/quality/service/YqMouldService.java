package com.litbo.quality.service;

import com.litbo.quality.bean.YqMould;
public interface YqMouldService {
    YqMould selectYqMouldById(String mbId);

    int updateYqMould(YqMould yqMould);
}
