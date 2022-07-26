package com.demo.talk.controller;

import com.demo.talk.entity.po.User;
import com.demo.talk.entity.vo.OnlineVo;
import com.demo.talk.entity.vo.UserVo;
import com.demo.talk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    //新增用户
    @PostMapping("/addUser")
    public String addUser(UserVo vo, Model model){
        vo.setAge(new Date().getYear()-vo.getBirth().getYear());
        vo.setIsDelete(0);
        vo.setCreateTime(new Date());
        vo.setModifyTime(new Date());
        boolean result = userMapper.addUser(vo);

        if (result){
            model.addAttribute("alert_info","用户创建成功！");
        }else{
            model.addAttribute("alert_info","用户创建失败！");
        }
        return "login";
    }


}
