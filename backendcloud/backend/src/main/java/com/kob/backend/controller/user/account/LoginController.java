package com.kob.backend.controller.user.account;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import com.kob.backend.service.user.account.LoginService;
import com.kob.backend.service.user.account.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/api/user/account/token/") // 将post携带的信息传到map中
    public Map<String, String> getToken(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");

        // 先检查该用户名是否已经注册
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> userList = new ArrayList<>();
        userList = userMapper.selectList(queryWrapper);
        if(userList.isEmpty()) {
            // 该用户不存在
            Map<String, String> res = new HashMap<>();
            res.put("error_message", "1");
            return res;
        }
        return loginService.getToken(username, password);
    }

//    @PostMapping("/user/account/token/") // 将post携带的信息传到map中
//    public Map<String, String> getToken(@RequestParam Map<String, String> map) {
//        String username = map.get("username");
//        String password = map.get("password");
//
//        // 先检查该用户名是否已经注册
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username", username);
//        List<User> userList = new ArrayList<>();
//        userList = userMapper.selectList(queryWrapper);
//        if(userList.isEmpty()) {
//            // 该用户不存在
//            Map<String, String> res = new HashMap<>();
//            res.put("error_message", "1");
//            return res;
//        }
//        return loginService.getToken(username, password);
//    }

}
