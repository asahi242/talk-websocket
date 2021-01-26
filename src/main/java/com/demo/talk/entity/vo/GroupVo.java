package com.demo.talk.entity.vo;

import com.demo.talk.entity.dto.FriendDto;
import com.demo.talk.entity.dto.GroupDto;
import com.demo.talk.entity.po.Friend;
import com.demo.talk.entity.po.Group;
import com.demo.talk.entity.po.User;
import lombok.Data;

import java.util.List;

@Data
public class GroupVo {
    private GroupDto group;
    private List<FriendDto> friends;
}
