package com.lesson.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SysDept implements Serializable {
    private Long id;

    private String name;

    private Long parentId;

    private Integer orderNum;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;

    private List<SysDept> children;

    private static final long serialVersionUID = 1L;
}