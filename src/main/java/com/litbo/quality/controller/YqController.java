package com.litbo.quality.controller;

import com.litbo.quality.bean.Yq;
import com.litbo.quality.service.YqService;
import com.litbo.quality.utils.CodeMsg;
import com.litbo.quality.utils.Result;
import com.litbo.quality.vo.YqEqInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     *
     * @param eqId
     * @return
     */
    @GetMapping("/getYqEqInfoList")
    public Result getYqEqInfoList(String eqId) {
        try {
            List<YqEqInfo> yqEqInfoList = yqService.getYqEqInfoList(eqId);
            return Result.success(yqEqInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }
    //展示所有仪器
    @RequestMapping(value = "listYq",method = RequestMethod.GET)
    public Result listYq() {
        return Result.success(yqService.listYq());
    }
    //添加仪器
    @RequestMapping(value = "insertYq",method = RequestMethod.POST)
    public Result insertYq(Yq yq) {
        try {
            int res = yqService.insertYq(yq);
            if(res > 0 ){
                return Result.success();
            }else {
                return Result.error(CodeMsg.SERVER_ERROR);
            }
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }


    }

    @RequestMapping(value = "selectYqById",method = RequestMethod.GET)
    public Result selectYqById(int jcyqId) {
        try {
            return Result.success(yqService.selectYqById(jcyqId));
        } catch (Exception e) {
            return Result.error();
        }
    }
    @RequestMapping(value = "updateYq",method = RequestMethod.POST)
    public Result updateYq(Yq yq){
        try {
            Integer res = yqService.updateYq(yq);
            if(res > 0 ){
                return Result.success();
            }else {
                return Result.error(CodeMsg.SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }


    @RequestMapping(value = "taskYq",method = RequestMethod.GET)
    public Result taskYq(){
        try {
            List list = yqService.taskYq();
            return Result.success(list);
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
}


