package com.gss.entity;

/**
 * @author Joker
 * 用户地址类
 */
public class UserAddress {
	private String aId;
	private String aUserId;
	private String aUserAddress;
	
	public UserAddress(String aId, String aUserId, String aUserAddress) {
		super();
		this.aId = aId;
		this.aUserId = aUserId;
		this.aUserAddress = aUserAddress;
	}
	
	public UserAddress() {
		super();
	}

	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getaUserId() {
		return aUserId;
	}
	public void setaUserId(String aUserId) {
		this.aUserId = aUserId;
	}
	public String getaUserAddress() {
		return aUserAddress;
	}
	public void setaUserAddress(String aUserAddress) {
		this.aUserAddress = aUserAddress;
	}

	@Override
	public String toString() {
		return "UserAddress [aId=" + aId + ", aUserId=" + aUserId
				+ ", aUserAddress=" + aUserAddress + "]";
	}
	
}
