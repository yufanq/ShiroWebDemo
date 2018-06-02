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
	public String toString() {
		return "Jurisdiction [jId=" + jId + ", jName=" + jName + ", lType="
				+ lType + ", jParent=" + jParent + ", lUri=" + lUri
				+ ", lStyle=" + lStyle + ", lPermission=" + lPermission
				+ ", lAvailable=" + lAvailable + "]";
	}

	


	
}