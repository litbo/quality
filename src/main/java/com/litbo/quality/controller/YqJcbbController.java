package com.litbo.quality.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.quality.bean.YqJcbb;
import com.litbo.quality.enums.EnumPlanStatus;
import com.litbo.quality.service.YqJcbbService;
import com.litbo.quality.utils.CodeMsg;
import com.litbo.quality.utils.Result;
import com.litbo.quality.vo.SelectYqJcbbByIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jcbb")
public class YqJcbbController {
    @Autowired
    private YqJcbbService jcbbService;
    @RequestMapping(value = "insertYqJcbb",method = RequestMethod.POST)
    public Result insertYqJcbb(YqJcbb yqJcbb){
        try {
            String userId = "1615925039";
            //TODO
            int res = jcbbService.insertYqJcbb(yqJcbb,userId);
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
    @RequestMapping(value = "listYqJcbbWaitDeteCtion",method = RequestMethod.POST)
    public Result listYqJcbbWaitDeteCtion(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                          @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        String userId ="1615925039";
        //TODO
        PageInfo pageInfo = jcbbService.listYqJcbbWaitDeteCtion(userId,pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @RequestMapping(value = "updateYqJcbbStatus",method = RequestMethod.POST)
    public Result updateYqJcjhStatus(Integer jcbbId,Integer jcjhId){
        String userId ="1615925039";
        int res = jcbbService.updateYqJcjhStatus(jcbbId,EnumPlanStatus.PLAN_FINISH.getCode(),userId,jcjhId);

        return Result.success();
    }
    @RequestMapping(value = "selectYqJcbbById",method = RequestMethod.GET)
    public Result selectYqJcbbById(Integer jcbbId){
        SelectYqJcbbByIdVo res = jcbbService.selectYqJcbbById(jcbbId);
        return Result.success(res);
    }
}
