package com.gss.entity;

import java.util.Date;

/**
 * @author Joker
 * 商品评论类，有以下属性：
 * 评论号、客户名、商品ID、评论内容、评论日期
 */
public class GoodsComment {
	private int cId;
	private String cUser;
	private String cGoodId;
	private String cDetail;
	private Date cDate;
	
	public GoodsComment(int cId, String cUser, String cGoodId,
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

	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
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

	@Override
	public String toString() {
		return "GoodsComment [cId=" + cId + ", cUser=" + cUser + ", cGoodId="
				+ cGoodId + ", cDetail=" + cDetail + ", cDate=" + cDate + "]";
	}
	
	
}
