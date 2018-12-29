package com.litbo.quality.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.YqJcjh;
import com.litbo.quality.service.YqJcjhService;
import com.litbo.quality.utils.CodeMsg;
import com.litbo.quality.utils.Result;
import com.litbo.quality.vo.ListJcjhByUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.Subject;

@RestController
@RequestMapping("jcjh")
public class YqJcjhController {
    @Autowired
    private YqJcjhService jcjhService;
    @RequestMapping(value = "insertYqJcjh",method = RequestMethod.POST)
    public Result insertYqJcjh(YqJcjh yqJcjh){
        try {
            int res = jcjhService.insertYqJcjh(yqJcjh);
            if(res > 0 ){
                return Result.success();
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @RequestMapping(value = "listYqJcjh",method = RequestMethod.GET)
    public Result listYqJcjh(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        //TODO
        String userId ="1615925023";
        PageInfo pageInfo = jcjhService.listYqJcjh(userId,pageNum,pageSize);
        return Result.success(pageInfo);
    }

}
