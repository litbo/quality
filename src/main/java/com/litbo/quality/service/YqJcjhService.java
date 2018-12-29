package com.litbo.quality.service;

import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.YqJcjh;


public interface YqJcjhService {
    int insertYqJcjh(YqJcjh yqJcjh);

    PageInfo listYqJcjh(String userId, int pageNumint,int pageSize);
}
