package com.litbo.quality.service;

import com.litbo.quality.bean.YqMould;

import java.util.List;

public interface YqMouldService {
    YqMould selectYqMouldById(String mbId);

    int updateYqMould(YqMould yqMould);

    List<YqMould> listYqMould();
}
