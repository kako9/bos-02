package com.lesson.dispatch.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class BasAssociatemember implements Serializable {
    private Integer id;

    private String zonecode;

    private String empno;

    private String empname;

    private BigDecimal standardkg;

    private BigDecimal standardlength;

    private Date standardtime;

    private Integer subordinateunit;

    private String type;

    private String phone;

    private static final long serialVersionUID = 1L;
}