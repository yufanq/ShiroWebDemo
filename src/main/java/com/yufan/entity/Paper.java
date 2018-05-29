package com.yufan.entity;

public class Paper {
    private Integer pId;

    private String pName;

    private Integer pNumber;

    private Integer pScore;

    private Integer pCount;

    private String pTeacher;

    private String pRqcodepath;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpNumber() {
        return pNumber;
    }

    public void setpNumber(Integer pNumber) {
        this.pNumber = pNumber;
    }

    public Integer getpScore() {
        return pScore;
    }

    public void setpScore(Integer pScore) {
        this.pScore = pScore;
    }

    public Integer getpCount() {
        return pCount;
    }

    public void setpCount(Integer pCount) {
        this.pCount = pCount;
    }

    public String getpTeacher() {
        return pTeacher;
    }

    public void setpTeacher(String pTeacher) {
        this.pTeacher = pTeacher == null ? null : pTeacher.trim();
    }

    public String getpRqcodepath() {
        return pRqcodepath;
    }

    public void setpRqcodepath(String pRqcodepath) {
        this.pRqcodepath = pRqcodepath == null ? null : pRqcodepath.trim();
    }
}