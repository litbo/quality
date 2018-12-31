package com.litbo.quality.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.YqJcjh;
import com.litbo.quality.enums.EnumPlanStatus;
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
    //所有的检测计划
    @RequestMapping(value = "listYqJcjhWaitDetection",method = RequestMethod.GET)
    public Result listYqJcjhWaitDetection(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        //TODO
        String userId ="1615925039";
        PageInfo pageInfo = jcjhService.listYqJcjhWaitDetection(userId,pageNum,pageSize);
        return Result.success(pageInfo);
    }
    //审核通过的计划
    @RequestMapping(value = "listYqJcjhFinish",method = RequestMethod.GET)
    public Result listYqJcjhWaitExamine(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                        @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        String userId ="1615925039";
        PageInfo pageInfo = jcjhService.listYqJcjhWaitExamine(userId,pageNum,pageSize);
        return Result.success(pageInfo);
    }
    //
    @RequestMapping(value = "updateYqJcjhStatus",method = RequestMethod.POST)
    public Result updateYqJcjhStatus(Integer jcjhId){
        String userId ="1615925039";
        int res = jcjhService.updateYqJcjhStatus(jcjhId,EnumPlanStatus.PLAN_FINISH.getCode(),userId);
        return Result.success();
    }


}
