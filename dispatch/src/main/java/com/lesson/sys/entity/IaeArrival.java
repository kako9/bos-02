package com.lesson.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class IaeArrival implements Serializable {
    private String id;

    private String sendcompany;

    private String consignee;

    private String cargoaddress;

    private String issueperson;

    private Date issuedate;

    private String workaddress;

    private Date storagedate;

    private Date outbounddate;

    private String failure;

    private Date timelimit;

    private String batch;

    private String goodsstate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSendcompany() {
        return sendcompany;
    }

    public void setSendcompany(String sendcompany) {
        this.sendcompany = sendcompany == null ? null : sendcompany.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getCargoaddress() {
        return cargoaddress;
    }

    public void setCargoaddress(String cargoaddress) {
        this.cargoaddress = cargoaddress == null ? null : cargoaddress.trim();
    }

    public String getIssueperson() {
        return issueperson;
    }

    public void setIssueperson(String issueperson) {
        this.issueperson = issueperson == null ? null : issueperson.trim();
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public String getWorkaddress() {
        return workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress == null ? null : workaddress.trim();
    }

    public Date getStoragedate() {
        return storagedate;
    }

    public void setStoragedate(Date storagedate) {
        this.storagedate = storagedate;
    }

    public Date getOutbounddate() {
        return outbounddate;
    }

    public void setOutbounddate(Date outbounddate) {
        this.outbounddate = outbounddate;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure == null ? null : failure.trim();
    }

    public Date getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Date timelimit) {
        this.timelimit = timelimit;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public String getGoodsstate() {
        return goodsstate;
    }

    public void setGoodsstate(String goodsstate) {
        this.goodsstate = goodsstate == null ? null : goodsstate.trim();
    }
}