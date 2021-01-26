package com.demo.talk.mapper;

import com.demo.talk.entity.dto.GroupDto;
import com.demo.talk.entity.po.Group;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface GroupMapper extends Mapper<Group> {
    List<GroupDto> getGroupById(int id);
}
