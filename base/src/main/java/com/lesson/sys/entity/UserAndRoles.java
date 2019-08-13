package com.lesson.sys.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserAndRoles {
    private Long id;
    private Long userId;
    private Long roleId;
    private List<Long> roleIdList;

}
