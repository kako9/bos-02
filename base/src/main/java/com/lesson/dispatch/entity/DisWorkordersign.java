package com.lesson.dispatch.entity;

import com.lesson.sys.entity.SysDept;
import com.lesson.sys.entity.SysUser;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class DisWorkordersign implements Serializable {

    private SysUser sysUser;

    private SysDept sysDept;

    private Integer id;

    private String workorderid;

    private String worksheetno;

    private Integer workordertype;

    private Integer signtype;

    private Integer courierint;

    private String couriername;

    private String recipient;

    private Integer signunit;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date signtime;

    private Integer invalidatemark;

    private String abnormalmark;

    private Integer inputpersoncode;

    private Integer inputpersonid;

    private Integer inputid;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date inputtime;

    private String requestcode;

    private Integer requeststate;

    private String confirmor;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date requesttime;

    private static final long serialVersionUID = 1L;

}