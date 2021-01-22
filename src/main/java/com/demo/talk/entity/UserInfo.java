package com.demo.talk.entity;

import com.demo.talk.entity.po.Group;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private int id;
    private String name;
    private int online;
    private List<Group> group;//分组
}
