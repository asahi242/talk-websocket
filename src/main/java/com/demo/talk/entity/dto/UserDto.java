package com.demo.talk.entity.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer uid;
    private String account;
    private String password;
    private String roleName;
}
