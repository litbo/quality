package com.litbo.quality.service;

import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.YqJcjh;
import com.litbo.quality.enums.EnumPlanStatus;


public interface YqJcjhService {
    int insertYqJcjh(YqJcjh yqJcjh);

    PageInfo listYqJcjhWaitDetection(String userId, int pageNumint,int pageSize);

    PageInfo listYqJcjhWaitExamine(String userId, int pageNum, int pageSize);

    int updateYqJcjhStatus(Integer jcjhId, Integer status, String userId);
}
