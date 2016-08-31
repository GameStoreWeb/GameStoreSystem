package com.gss.entity;

/**
 * @author Joker
 * ”√ªß¿‡
 */
public class User {
	private String uId;
	private String uPwd;
	private String uLoginName;
	private String uSex;
	private String uName;
	private String uTelephone;
	
	public User(String uId, String uPwd, String uLoginName, String uSex,
			String uName, String uTelephone) {
		super();
		this.uId = uId;
		this.uPwd = uPwd;
		this.uLoginName = uLoginName;
		this.uSex = uSex;
		this.uName = uName;
		this.uTelephone = uTelephone;
	}
	
	public User() {
		super();
	}

	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuLoginName() {
		return uLoginName;
	}
	public void setuLoginName(String uLoginName) {
		this.uLoginName = uLoginName;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuTelephone() {
		return uTelephone;
	}
	public void setuTelephone(String uTelephone) {
		this.uTelephone = uTelephone;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uPwd=" + uPwd + ", uLoginName="
				+ uLoginName + ", uSex=" + uSex + ", uName=" + uName
				+ ", uTelephone=" + uTelephone + "]";
	}
	
	
	
}
