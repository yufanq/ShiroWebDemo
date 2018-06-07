package com.yufan.entity;

import java.util.Set;

public class Admin {
    private Integer aId;

    private String aAccount;

    private String aPassword;

    private String aNickname;

    private String aSalt;

    private Byte aLocked;
    
    private Set<Role> roles; // 管理员拥有的角色列表 
    
    private Set<Jurisdiction> jurisdictions;
    public Admin(){
    	
    }
    public Admin(String account,String password){
    	aAccount = account;
    	aPassword = password;
    }
    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaAccount() {
        return aAccount;
    }

    public void setaAccount(String aAccount) {
        this.aAccount = aAccount == null ? null : aAccount.trim();
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword == null ? null : aPassword.trim();
    }

    public String getaNickname() {
        return aNickname;
    }

    public void setaNickname(String aNickname) {
        this.aNickname = aNickname == null ? null : aNickname.trim();
    }
    public String getCredentialsSalt() {
        return aAccount + aSalt;
    }
    public String getaSalt() {
        return  aSalt;
    }

    public void setaSalt(String aSalt) {
        this.aSalt = aSalt == null ? null : aSalt.trim();
    }

    public Byte getaLocked() {
        return aLocked;
    }

    public void setaLocked(Byte aLocked) {
        this.aLocked = aLocked;
    }
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Set<Jurisdiction> getJurisdictions() {
		return jurisdictions;
	}
	public void setJurisdictions(Set<Jurisdiction> jurisdictions) {
		this.jurisdictions = jurisdictions;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aAccount == null) ? 0 : aAccount.hashCode());
		result = prime * result + ((aId == null) ? 0 : aId.hashCode());
		result = prime * result + ((aLocked == null) ? 0 : aLocked.hashCode());
		result = prime * result
				+ ((aNickname == null) ? 0 : aNickname.hashCode());
		result = prime * result
				+ ((aPassword == null) ? 0 : aPassword.hashCode());
		result = prime * result + ((aSalt == null) ? 0 : aSalt.hashCode());
		result = prime * result
				+ ((jurisdictions == null) ? 0 : jurisdictions.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		Admin other = (Admin) obj;
		if (aAccount == null) {
			if (other.aAccount != null)
				return false;
		} else if (!aAccount.equals(other.aAccount))
			return false;
		if (aId == null) {
			if (other.aId != null)
				return false;
		} else if (!aId.equals(other.aId))
			return false;
		if (aLocked == null) {
			if (other.aLocked != null)
				return false;
		} else if (!aLocked.equals(other.aLocked))
			return false;
		if (aNickname == null) {
			if (other.aNickname != null)
				return false;
		} else if (!aNickname.equals(other.aNickname))
			return false;
		if (aPassword == null) {
			if (other.aPassword != null)
				return false;
		} else if (!aPassword.equals(other.aPassword))
			return false;
		if (aSalt == null) {
			if (other.aSalt != null)
				return false;
		} else if (!aSalt.equals(other.aSalt))
			return false;
		if (jurisdictions == null) {
			if (other.jurisdictions != null)
				return false;
		} else if (!jurisdictions.equals(other.jurisdictions))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aAccount=" + aAccount + ", aPassword="
				+ aPassword + ", aNickname=" + aNickname + ", aSalt=" + aSalt
				+ ", aLocked=" + aLocked + ", roles=" + roles
				+ ", jurisdictions=" + jurisdictions + "]";
	}

    
}