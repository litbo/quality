package com.litbo.quality.controller;

import com.litbo.quality.bean.YqMould;
import com.litbo.quality.service.YqMouldService;
import com.litbo.quality.utils.CodeMsg;
import com.litbo.quality.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mould")
public class YqMouldController {
    @Autowired
    private YqMouldService mouldSerrvice;

    @RequestMapping(value = "selectYqMouldById",method = RequestMethod.GET)
    public Result selectYqMouldById(@RequestParam(name = "mbId") String mbId){
        try {
            YqMould mould = mouldSerrvice.selectYqMouldById(mbId);
            return Result.success(mould);
        }catch (Exception e){
            return  Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @RequestMapping(value = "updateYqMould",method = RequestMethod.POST)
    public Result updateYqMould(@RequestBody YqMould yqMould){
        try {
            int res = mouldSerrvice.updateYqMould(yqMould);
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
