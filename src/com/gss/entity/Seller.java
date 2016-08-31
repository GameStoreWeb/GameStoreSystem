package com.gss.entity;

/**
 * @author Joker
 * 商家类，包含以下属性：
 * 商家ID、商家名、商家地址、电话、登录密码
 */
public class Seller {
	private String sId;
	private String sName;
	private String sAddress;
	private String sPhone;
	private String sPwd;
	
	public Seller(String sId, String sName, String sAddress, String sPhone,
			String sPwd) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sAddress = sAddress;
		this.sPhone = sPhone;
		this.sPwd = sPwd;
	}
	
	public Seller() {
		super();
	}

	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getsPwd() {
		return sPwd;
	}
	public void setsPwd(String sPwd) {
		this.sPwd = sPwd;
	}

	@Override
	public String toString() {
		return "Seller [sId=" + sId + ", sName=" + sName + ", sAddress="
				+ sAddress + ", sPhone=" + sPhone + ", sPwd=" + sPwd + "]";
	}
	
	
	
}
