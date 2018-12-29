package com.litbo.quality.controller;

import com.litbo.quality.bean.YqJcbb;
import com.litbo.quality.service.YqJcbbService;
import com.litbo.quality.utils.CodeMsg;
import com.litbo.quality.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jcbb")
public class YqJcbbController {
    @Autowired
    private YqJcbbService jcbbService;
    @RequestMapping(value = "insertYqJcbb",method = RequestMethod.POST)
    public Result insertYqJcbb(YqJcbb yqJcbb){
        try {
            int res = jcbbService.insertYqJcbb(yqJcbb);
            if(res > 0 ){
                return Result.success();
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
}
