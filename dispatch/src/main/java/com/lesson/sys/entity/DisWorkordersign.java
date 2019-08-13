package com.lesson.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class DisWorkordersign implements Serializable {
    private Integer id;

    private String workorderid;

    private String worksheetno;

    private Integer workordertype;

    private String requestcode;

    private Integer requeststate;

    private String confirmor;

    private Date requesttime;

    private Integer signtype;

    private Integer courierint;

    private String couriername;

    private String recipient;

    private Integer signunit;

    private Date signtime;

    private Integer invalidatemark;

    private String abnormalmark;

    private Integer inputpersoncode;

    private Integer inputpersonid;

    private Integer inputid;

    private Date inputtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(String workorderid) {
        this.workorderid = workorderid == null ? null : workorderid.trim();
    }

    public String getWorksheetno() {
        return worksheetno;
    }

    public void setWorksheetno(String worksheetno) {
        this.worksheetno = worksheetno == null ? null : worksheetno.trim();
    }

    public Integer getWorkordertype() {
        return workordertype;
    }

    public void setWorkordertype(Integer workordertype) {
        this.workordertype = workordertype;
    }

    public String getRequestcode() {
        return requestcode;
    }

    public void setRequestcode(String requestcode) {
        this.requestcode = requestcode == null ? null : requestcode.trim();
    }

    public Integer getRequeststate() {
        return requeststate;
    }

    public void setRequeststate(Integer requeststate) {
        this.requeststate = requeststate;
    }

    public String getConfirmor() {
        return confirmor;
    }

    public void setConfirmor(String confirmor) {
        this.confirmor = confirmor == null ? null : confirmor.trim();
    }

    public Date getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Date requesttime) {
        this.requesttime = requesttime;
    }

    public Integer getSigntype() {
        return signtype;
    }

    public void setSigntype(Integer signtype) {
        this.signtype = signtype;
    }

    public Integer getCourierint() {
        return courierint;
    }

    public void setCourierint(Integer courierint) {
        this.courierint = courierint;
    }

    public String getCouriername() {
        return couriername;
    }

    public void setCouriername(String couriername) {
        this.couriername = couriername == null ? null : couriername.trim();
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient == null ? null : recipient.trim();
    }

    public Integer getSignunit() {
        return signunit;
    }

    public void setSignunit(Integer signunit) {
        this.signunit = signunit;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public Integer getInvalidatemark() {
        return invalidatemark;
    }

    public void setInvalidatemark(Integer invalidatemark) {
        this.invalidatemark = invalidatemark;
    }

    public String getAbnormalmark() {
        return abnormalmark;
    }

    public void setAbnormalmark(String abnormalmark) {
        this.abnormalmark = abnormalmark == null ? null : abnormalmark.trim();
    }

    public Integer getInputpersoncode() {
        return inputpersoncode;
    }

    public void setInputpersoncode(Integer inputpersoncode) {
        this.inputpersoncode = inputpersoncode;
    }

    public Integer getInputpersonid() {
        return inputpersonid;
    }

    public void setInputpersonid(Integer inputpersonid) {
        this.inputpersonid = inputpersonid;
    }

    public Integer getInputid() {
        return inputid;
    }

    public void setInputid(Integer inputid) {
        this.inputid = inputid;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }
}