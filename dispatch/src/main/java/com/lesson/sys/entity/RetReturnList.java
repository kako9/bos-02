package com.lesson.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class RetReturnList implements Serializable {
    private Integer id;

    private String applicationno;

    private String worksheetno;

    private Integer returntype;

    private String apremark;

    private Integer aploss;

    private Date entrytime;

    private Integer receivegunit;

    private Integer invalidatesign;

    private Integer returnunit;

    private Date recordingtime;

    private Integer entryunit;

    private String personname;

    private Date confirmationtime;

    private Integer confirmationunit;

    private String confirmationpersonname;

    private Integer treatmentstate;

    private Integer apreturnstatus;

    private Integer identificationsign;

    private String handlingopinions;

    private String denialtype;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationno() {
        return applicationno;
    }

    public void setApplicationno(String applicationno) {
        this.applicationno = applicationno == null ? null : applicationno.trim();
    }

    public String getWorksheetno() {
        return worksheetno;
    }

    public void setWorksheetno(String worksheetno) {
        this.worksheetno = worksheetno == null ? null : worksheetno.trim();
    }

    public Integer getReturntype() {
        return returntype;
    }

    public void setReturntype(Integer returntype) {
        this.returntype = returntype;
    }

    public String getApremark() {
        return apremark;
    }

    public void setApremark(String apremark) {
        this.apremark = apremark == null ? null : apremark.trim();
    }

    public Integer getAploss() {
        return aploss;
    }

    public void setAploss(Integer aploss) {
        this.aploss = aploss;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Integer getReceivegunit() {
        return receivegunit;
    }

    public void setReceivegunit(Integer receivegunit) {
        this.receivegunit = receivegunit;
    }

    public Integer getInvalidatesign() {
        return invalidatesign;
    }

    public void setInvalidatesign(Integer invalidatesign) {
        this.invalidatesign = invalidatesign;
    }

    public Integer getReturnunit() {
        return returnunit;
    }

    public void setReturnunit(Integer returnunit) {
        this.returnunit = returnunit;
    }

    public Date getRecordingtime() {
        return recordingtime;
    }

    public void setRecordingtime(Date recordingtime) {
        this.recordingtime = recordingtime;
    }

    public Integer getEntryunit() {
        return entryunit;
    }

    public void setEntryunit(Integer entryunit) {
        this.entryunit = entryunit;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname == null ? null : personname.trim();
    }

    public Date getConfirmationtime() {
        return confirmationtime;
    }

    public void setConfirmationtime(Date confirmationtime) {
        this.confirmationtime = confirmationtime;
    }

    public Integer getConfirmationunit() {
        return confirmationunit;
    }

    public void setConfirmationunit(Integer confirmationunit) {
        this.confirmationunit = confirmationunit;
    }

    public String getConfirmationpersonname() {
        return confirmationpersonname;
    }

    public void setConfirmationpersonname(String confirmationpersonname) {
        this.confirmationpersonname = confirmationpersonname == null ? null : confirmationpersonname.trim();
    }

    public Integer getTreatmentstate() {
        return treatmentstate;
    }

    public void setTreatmentstate(Integer treatmentstate) {
        this.treatmentstate = treatmentstate;
    }

    public Integer getApreturnstatus() {
        return apreturnstatus;
    }

    public void setApreturnstatus(Integer apreturnstatus) {
        this.apreturnstatus = apreturnstatus;
    }

    public Integer getIdentificationsign() {
        return identificationsign;
    }

    public void setIdentificationsign(Integer identificationsign) {
        this.identificationsign = identificationsign;
    }

    public String getHandlingopinions() {
        return handlingopinions;
    }

    public void setHandlingopinions(String handlingopinions) {
        this.handlingopinions = handlingopinions == null ? null : handlingopinions.trim();
    }

    public String getDenialtype() {
        return denialtype;
    }

    public void setDenialtype(String denialtype) {
        this.denialtype = denialtype == null ? null : denialtype.trim();
    }
}