package com.demo.talk.entity;

import com.demo.talk.entity.dto.GroupDto;
import com.demo.talk.entity.po.Group;
import com.demo.talk.entity.vo.GroupVo;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private int id;
    private String name;
    private int online;
    private List<GroupDto> group;//分组
}
