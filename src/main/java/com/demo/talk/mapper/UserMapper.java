package com.demo.talk.mapper;

import com.demo.talk.entity.dto.FriendDto;
import com.demo.talk.entity.po.Friend;
import com.demo.talk.entity.po.Group;
import com.demo.talk.entity.po.User;
import com.demo.talk.entity.UserInfo;
import com.demo.talk.entity.vo.OnlineVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Component
public interface UserMapper extends Mapper<User> {
    User getByName(String account);
    int setOnline(OnlineVo vo);
    List<FriendDto> getFriend(@Param("groupid") Integer groupid, @Param("userid") Integer userid);

}

