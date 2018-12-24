package com.litbo.quality.controller;

import com.litbo.quality.service.UserService;
import com.litbo.quality.utils.Result;
import com.litbo.quality.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
