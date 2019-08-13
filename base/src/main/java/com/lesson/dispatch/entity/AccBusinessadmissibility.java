package com.lesson.dispatch.entity;

import com.lesson.sys.entity.SysDept;
import com.lesson.sys.entity.SysUser;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccBusinessadmissibility implements Serializable {

    private SysDept sysDept;

    private SysUser sysUser;

    private AccWorkorder accWorkorder;

    private Integer id;

    private String businessnoticeno;

    private Date reservationtime;

    private String customname;

    private String pickupaddress;

    private String customcode;

    private String linkman;

    private String telphone;

    private BigDecimal weight;

    private BigDecimal volume;

    private String importanthints;

    private String arrivecity;

    private Integer pickerinfo;

    private String sendaddress;

    private Integer processingunit;

    private Integer notificationsource;

    private Integer customnomodifyflag;

    private String singletype;

    private Integer packagesnum;

    private BigDecimal actualweight;

    private BigDecimal billingweight;

    private Double packingfee;

    private Integer actualpacking;

    private static final long serialVersionUID = 1L;

}