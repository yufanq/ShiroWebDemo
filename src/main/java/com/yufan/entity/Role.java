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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((jurisdictions == null) ? 0 : jurisdictions.hashCode());
		result = prime * result
				+ ((rAvailable == null) ? 0 : rAvailable.hashCode());
		result = prime * result + ((rId == null) ? 0 : rId.hashCode());
		result = prime * result + ((rName == null) ? 0 : rName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (jurisdictions == null) {
			if (other.jurisdictions != null)
				return false;
		} else if (!jurisdictions.equals(other.jurisdictions))
			return false;
		if (rAvailable == null) {
			if (other.rAvailable != null)
				return false;
		} else if (!rAvailable.equals(other.rAvailable))
			return false;
		if (rId == null) {
			if (other.rId != null)
				return false;
		} else if (!rId.equals(other.rId))
			return false;
		if (rName == null) {
			if (other.rName != null)
				return false;
		} else if (!rName.equals(other.rName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rName=" + rName + ", rAvailable="
				+ rAvailable + ", jurisdictions=" + jurisdictions + "]";
	}
    
}