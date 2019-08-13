package com.lesson.Return.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
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
}