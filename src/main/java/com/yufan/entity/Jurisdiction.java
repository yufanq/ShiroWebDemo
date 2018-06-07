package com.yufan.entity;

public class Jurisdiction {
    private Integer jId;

    private String jName;

    private ResourceType lType = ResourceType.menu; // 资源类型
    
    private Integer jParent;
    private String lUri;

    private String lStyle;
    
    private String lPermission;

    private Byte lAvailable;
    
    
    public static enum ResourceType {
        menu("菜单"), button("按钮"), list("列表");

        private final String info;
        private ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

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

    public ResourceType getlType() {
		return lType;
	}

	public void setlType(ResourceType lType) {
		this.lType = lType;
	}

	public Integer getjParent() {
		return jParent;
	}

	public void setjParent(Integer jParent) {
		this.jParent = jParent;
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

    public boolean isRootNode() {
        return jId == 1;
    }

	public String getlStyle() {
		return lStyle;
	}

	public void setlStyle(String lStyle) {
		this.lStyle = lStyle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jId == null) ? 0 : jId.hashCode());
		result = prime * result + ((jName == null) ? 0 : jName.hashCode());
		result = prime * result + ((jParent == null) ? 0 : jParent.hashCode());
		result = prime * result
				+ ((lAvailable == null) ? 0 : lAvailable.hashCode());
		result = prime * result
				+ ((lPermission == null) ? 0 : lPermission.hashCode());
		result = prime * result + ((lStyle == null) ? 0 : lStyle.hashCode());
		result = prime * result + ((lType == null) ? 0 : lType.hashCode());
		result = prime * result + ((lUri == null) ? 0 : lUri.hashCode());
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
		Jurisdiction other = (Jurisdiction) obj;
		if (jId == null) {
			if (other.jId != null)
				return false;
		} else if (!jId.equals(other.jId))
			return false;
		if (jName == null) {
			if (other.jName != null)
				return false;
		} else if (!jName.equals(other.jName))
			return false;
		if (jParent == null) {
			if (other.jParent != null)
				return false;
		} else if (!jParent.equals(other.jParent))
			return false;
		if (lAvailable == null) {
			if (other.lAvailable != null)
				return false;
		} else if (!lAvailable.equals(other.lAvailable))
			return false;
		if (lPermission == null) {
			if (other.lPermission != null)
				return false;
		} else if (!lPermission.equals(other.lPermission))
			return false;
		if (lStyle == null) {
			if (other.lStyle != null)
				return false;
		} else if (!lStyle.equals(other.lStyle))
			return false;
		if (lType != other.lType)
			return false;
		if (lUri == null) {
			if (other.lUri != null)
				return false;
		} else if (!lUri.equals(other.lUri))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jurisdiction [jId=" + jId + ", jName=" + jName + ", lType="
				+ lType + ", jParent=" + jParent + ", lUri=" + lUri
				+ ", lStyle=" + lStyle + ", lPermission=" + lPermission
				+ ", lAvailable=" + lAvailable + "]";
	}

	


	
}