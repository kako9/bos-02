package com.lesson.dispatch.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AccWorksheet implements Serializable {
    private Integer id;

    private String worksheetno;

    private String destination;

    private String producttime;

    private Integer total;

    private BigDecimal weight;

    private String stowagerequirements;

    private static final long serialVersionUID = 1L;
}