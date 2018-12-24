package com.litbo.quality.vo;

import com.litbo.quality.bean.SUser;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author zjc
 * @create 2018-12-23 16:50
 */
@Data
public class UserInfo {

    private SUser sUser;

    private Map<Integer, List<String>> roleMap;

}
