package com.demo.talk.mapper;

import com.demo.talk.entity.po.Friend;
import com.demo.talk.entity.po.User;
import com.demo.talk.entity.vo.OnlineVo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;


@Component
public interface FriendMapper extends Mapper<Friend> {

}

