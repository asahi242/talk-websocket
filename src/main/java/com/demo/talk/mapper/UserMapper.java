package com.demo.talk.mapper;

import com.demo.talk.entity.po.Group;
import com.demo.talk.entity.po.User;
import com.demo.talk.entity.UserInfo;
import com.demo.talk.entity.vo.OnlineVo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Component
public interface UserMapper extends Mapper<User> {
    User getByName(String account);
    int setOnline(OnlineVo vo);
    List<Group> getGroupById(int id);
}

