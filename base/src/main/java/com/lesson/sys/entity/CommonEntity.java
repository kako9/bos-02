package com.lesson.sys.entity;

import lombok.Data;

import java.util.List;

@Data
public class CommonEntity {

    private Long id;
    private String label;
    private String url;
    private Byte delFlag;
    private List<CommonEntity> children;

}
