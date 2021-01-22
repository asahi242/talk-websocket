package com.demo.talk.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GroupDto {
    private Integer userId;
    private Integer groupNum;
    private String groupName;
    private Date createTime;
    private Date modifyTime;
}
