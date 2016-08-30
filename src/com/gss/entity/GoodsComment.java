package com.gss.entity;

import java.util.Date;

public class GoodsComment {
	private String cId;
	private String cUser;
	private String cGoodId;
	private String cDetail;
	private Date cDate;
	
	public GoodsComment(String cId, String cUser, String cGoodId,
			String cDetail, Date cDate) {
		super();
		this.cId = cId;
		this.cUser = cUser;
		this.cGoodId = cGoodId;
		this.cDetail = cDetail;
		this.cDate = cDate;
	}
	
	public GoodsComment() {
		super();
	}

	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcUser() {
		return cUser;
	}
	public void setcUser(String cUser) {
		this.cUser = cUser;
	}
	public String getcGoodId() {
		return cGoodId;
	}
	public void setcGoodId(String cGoodId) {
		this.cGoodId = cGoodId;
	}
	public String getcDetail() {
		return cDetail;
	}
	public void setcDetail(String cDetail) {
		this.cDetail = cDetail;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	
	
}
