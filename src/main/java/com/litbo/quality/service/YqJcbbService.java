package com.litbo.quality.service;

import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.YqJcbb;
import com.litbo.quality.vo.SelectYqJcbbByIdVo;

public interface YqJcbbService {
    int insertYqJcbb(YqJcbb yqJcbb, String userId);

    PageInfo listYqJcbbWaitDeteCtion(String userId, int pageNum, int pageSize);

    int updateYqJcjhStatus(Integer jcbbId, Integer code, String userId, Integer jcjhId);

    SelectYqJcbbByIdVo selectYqJcbbById(Integer jcbbId);
}
