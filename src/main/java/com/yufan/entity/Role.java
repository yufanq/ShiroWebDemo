package com.yufan.entity;

import java.util.List;

public class Role {
    private Integer rId;

    private String rName;

    private Byte rAvailable;
    
    private List<Jurisdiction> jurisdictions; // 拥有权限
    
    public List<Jurisdiction> getJurisdictions() {
		return jurisdictions;
	}

	public void setJurisdictions(List<Jurisdiction> jurisdictions) {
		this.jurisdictions = jurisdictions;
	}

	public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public Byte getrAvailable() {
        return rAvailable;
    }

    public void setrAvailable(Byte rAvailable) {
        this.rAvailable = rAvailable;
    }

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rName=" + rName + ", rAvailable="
				+ rAvailable + ", jurisdictions=" + jurisdictions + "]";
	}
    
}