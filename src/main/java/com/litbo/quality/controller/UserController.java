package com.litbo.quality.controller;

import com.litbo.quality.bean.SUser;
import com.litbo.quality.bean.YqRole;
import com.litbo.quality.service.UserService;
import com.litbo.quality.utils.Result;
import com.litbo.quality.vo.UserInfo;
import com.litbo.quality.vo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-23 19:42
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUserRole")
    public Result addUserRole(YqRole yqRole){
        try {
            userService.addYqRole(yqRole);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    @GetMapping("/deleteUserRole")
    public Result deleteUserRole(YqRole yqRole){
        try {
            userService.deleteYqRole(yqRole);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }

    /**
     * 人员分配设置加载
     * @param eqId
     * @param statusRole
     * @return
     */
    @GetMapping("/getUserRole")
    public Result getUserRole(String eqId,Integer statusRole){
        try {
            List<UserRole> userRoles = userService.getUserRoleStatus(eqId, statusRole);
            return Result.success(userRoles);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }

    /**
     * 人员添加
     * @param user
     * @return
     */
    @PostMapping("addUser")
    public Result addUser(SUser user){
        try {
            userService.addUser(user);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    /**
     * 人员管理
     * @return
     */
    @GetMapping("/getUserInfo")
    public Result getUserInfo(){
        try {
            List<UserInfo> userInfoList = userService.getUserInfoList();
            return Result.success(userInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取数据失败");
        }
    }

    /**
     * 检测人员工作量管理
     * @param username
     * @param beginTime
     * @param endTime
     * @param pageSize
     * @param pageNum
     * @return
     */
    @GetMapping("/getUsreYqjcbb")
    public Result getUsreYqjcbb(@RequestParam(required = false) String username, @RequestParam(required = false) Date beginTime,
                                @RequestParam(required = false) Date endTime,
                                @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            List<UserInfo> userInfos = userService.getUserYqJcbb(username, beginTime, endTime,pageNum,pageSize);
            return Result.success(userInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取信息失败");
        }
    }

}
