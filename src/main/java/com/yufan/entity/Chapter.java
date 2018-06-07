package com.yufan.entity;

import java.util.List;

public class Chapter {
    private Integer cId;

    private Integer bId;

    private Integer cNumber;
    
    private String cName;
    
    private List<Kldpoint> kldpoints;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getcNumber() {
		return cNumber;
	}

	public void setcNumber(Integer cNumber) {
		this.cNumber = cNumber;
	}

	public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

	public List<Kldpoint> getKldpoints() {
		return kldpoints;
	}

	public void setKldpoints(List<Kldpoint> kldpoints) {
		this.kldpoints = kldpoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bId == null) ? 0 : bId.hashCode());
		result = prime * result + ((cId == null) ? 0 : cId.hashCode());
		result = prime * result + ((cName == null) ? 0 : cName.hashCode());
		result = prime * result + ((cNumber == null) ? 0 : cNumber.hashCode());
		result = prime * result
				+ ((kldpoints == null) ? 0 : kldpoints.hashCode());
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
		Chapter other = (Chapter) obj;
		if (bId == null) {
			if (other.bId != null)
				return false;
		} else if (!bId.equals(other.bId))
			return false;
		if (cId == null) {
			if (other.cId != null)
				return false;
		} else if (!cId.equals(other.cId))
			return false;
		if (cName == null) {
			if (other.cName != null)
				return false;
		} else if (!cName.equals(other.cName))
			return false;
		if (cNumber == null) {
			if (other.cNumber != null)
				return false;
		} else if (!cNumber.equals(other.cNumber))
			return false;
		if (kldpoints == null) {
			if (other.kldpoints != null)
				return false;
		} else if (!kldpoints.equals(other.kldpoints))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chapter [cId=" + cId + ", bId=" + bId + ", cNumber=" + cNumber
				+ ", cName=" + cName + ", kldpoints=" + kldpoints + "]";
	}
    
}