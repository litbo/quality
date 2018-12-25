package com.litbo.quality.controller;

import com.litbo.quality.service.YqService;
import com.litbo.quality.utils.Result;
import com.litbo.quality.vo.YqEqInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-25 17:38
 */
@RestController
@RequestMapping("/yq")
public class YqController {

    @Autowired
    private YqService yqService;

    /**
     * 检测仪器分配设置
     * @param eqId
     * @return
     */
    @GetMapping("/getYqEqInfoList")
    public Result getYqEqInfoList(String eqId){
        try {
            List<YqEqInfo> yqEqInfoList = yqService.getYqEqInfoList(eqId);
            return Result.success(yqEqInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }

}
