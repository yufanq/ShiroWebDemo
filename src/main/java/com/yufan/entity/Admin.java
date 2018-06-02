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
	public String toString() {
		return "Admin [aId=" + aId + ", aAccount=" + aAccount + ", aPassword="
				+ aPassword + ", aNickname=" + aNickname + ", aSalt=" + aSalt
				+ ", aLocked=" + aLocked + ", roles=" + roles
				+ ", jurisdictions=" + jurisdictions + "]";
	}

    
}