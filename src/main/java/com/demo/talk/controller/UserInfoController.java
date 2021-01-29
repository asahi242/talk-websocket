package com.demo.talk.controller;

import com.demo.talk.entity.po.User;
import com.demo.talk.entity.vo.OnlineVo;
import com.demo.talk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserMapper userMapper;
    //设置在线/离线
    @GetMapping("/setonline")
    public Boolean setOnline(OnlineVo vo){
        Boolean result = false;
        int i = userMapper.setOnline(vo);
        if (i>0){
            result = true;
        }
        return result;
    }
    //根据用户名获取用户
    @PostMapping("/getByName")
    @ResponseBody
    public Boolean getByName(String name){
        User user = userMapper.getByName(name);
        if (user!=null){
            return true;
        }
        return false;
    }


}
