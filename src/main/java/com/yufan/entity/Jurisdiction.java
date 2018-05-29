package com.yufan.entity;

public class Jurisdiction {
    private Integer jId;

    private String jName;

    private String lType;

    private String lUri;

    private String lPermission;

    private Byte lAvailable;

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName == null ? null : jName.trim();
    }

    public String getlType() {
        return lType;
    }

    public void setlType(String lType) {
        this.lType = lType == null ? null : lType.trim();
    }

    public String getlUri() {
        return lUri;
    }

    public void setlUri(String lUri) {
        this.lUri = lUri == null ? null : lUri.trim();
    }

    public String getlPermission() {
        return lPermission;
    }

    public void setlPermission(String lPermission) {
        this.lPermission = lPermission == null ? null : lPermission.trim();
    }

    public Byte getlAvailable() {
        return lAvailable;
    }

    public void setlAvailable(Byte lAvailable) {
        this.lAvailable = lAvailable;
    }
}