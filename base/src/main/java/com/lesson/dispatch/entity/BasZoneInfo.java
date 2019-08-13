package com.lesson.dispatch.entity;

import java.io.Serializable;

public class BasZoneInfo implements Serializable {
    private Integer id;

    private String zonecode;

    private String zonename;

    private Integer zonepeople;

    private String telphone;

    private Integer bubordinateunit;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZonecode() {
        return zonecode;
    }

    public void setZonecode(String zonecode) {
        this.zonecode = zonecode == null ? null : zonecode.trim();
    }

    public String getZonename() {
        return zonename;
    }

    public void setZonename(String zonename) {
        this.zonename = zonename == null ? null : zonename.trim();
    }

    public Integer getZonepeople() {
        return zonepeople;
    }

    public void setZonepeople(Integer zonepeople) {
        this.zonepeople = zonepeople;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public Integer getBubordinateunit() {
        return bubordinateunit;
    }

    public void setBubordinateunit(Integer bubordinateunit) {
        this.bubordinateunit = bubordinateunit;
    }
}