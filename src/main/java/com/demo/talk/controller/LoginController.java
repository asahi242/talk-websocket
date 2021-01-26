package com.demo.talk.controller;

import com.demo.talk.entity.dto.FriendDto;
import com.demo.talk.entity.dto.GroupDto;
import com.demo.talk.entity.po.Group;
import com.demo.talk.entity.po.User;
import com.demo.talk.entity.UserInfo;
import com.demo.talk.entity.vo.GroupVo;
import com.demo.talk.entity.vo.OnlineVo;
import com.demo.talk.entity.vo.UserVo;
import com.demo.talk.mapper.FriendMapper;
import com.demo.talk.mapper.GroupMapper;
import com.demo.talk.mapper.UserMapper;
import com.demo.talk.utils.EhcacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private FriendMapper friendMapper;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,Model model, UserVo vo){
        User user = userMapper.getByName(vo.getName());
        if ("".equals(vo.getName())||"".equals(vo.getPassword())){
            model.addAttribute("login_error","用户名或密码不能为空！");
        } else if (user==null){
            model.addAttribute("login_error","没有此用户！");
        }else if (!user.getPassword().equals(vo.getPassword())){
            model.addAttribute("login_error","密码不正确！");
        }else{
            //设置在线
            OnlineVo onlineVo = new OnlineVo();
            onlineVo.setId(user.getId());
            onlineVo.setOnline(1);
            int i = userMapper.setOnline(onlineVo);
            user.setOnline(1);
            EhcacheUtils.setElement("USER_"+user.getName(),user);
            //根据ID获取分组信息
            List<GroupDto> groups = groupMapper.getGroupById(user.getId());
            for (int j=0;j<groups.size();j++){
                List<FriendDto> friends = userMapper.getFriend(groups.get(j).getGroupNum(), groups.get(j).getUserId());
                groups.get(j).setFriends(friends);
            }

            //封装用户信息
            UserInfo userInfo = new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setName(user.getName());
            userInfo.setOnline(user.getOnline());
            userInfo.setGroup(groups);
            request.getSession().setAttribute("UserInfo",userInfo);
            return "index";
        }
        model.addAttribute("name",vo.getName());
        model.addAttribute("password",vo.getPassword());
        return "login";
    }
}
