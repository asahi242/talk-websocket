package com.demo.talk.entity.dto;

import lombok.Data;

@Data
public class FriendDto {
    private Integer groupNum;
    private Integer userId;
    private String name;
    private Integer online;
    private Integer sex;
    private Integer age;
}
