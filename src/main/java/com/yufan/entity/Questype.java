package com.yufan.entity;

public class Questype {
    private Integer tId;

    private String tName;

    private Integer tValue;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public Integer gettValue() {
        return tValue;
    }

    public void settValue(Integer tValue) {
        this.tValue = tValue;
    }
}