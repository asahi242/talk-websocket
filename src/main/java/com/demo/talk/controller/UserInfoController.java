package com.demo.talk.controller;

import com.demo.talk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserMapper userInfoMapper;
    //设置在线/离线


}
