package com.gss.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Joker
 * 商家订单类
 */
public class SellerOrder {
	private String sId;
	private String uId;
	private String oAddres;
	private String startdate;
	private boolean oIsTake;
	private double oTotal;
	private Date odeliverDate;
	private boolean oIsDeliver;
	private List<Goods> goodsItem;
	
	public SellerOrder(String sId, String uId, String oAddres,
			String startdate, boolean oIsTake, double oTotal,
			Date odeliverDate, boolean oIsDeliver, List<Goods> goodsItem) {
		super();
		this.sId = sId;
		this.uId = uId;
		this.oAddres = oAddres;
		this.startdate = startdate;
		this.oIsTake = oIsTake;
		this.oTotal = oTotal;
		this.odeliverDate = odeliverDate;
		this.oIsDeliver = oIsDeliver;
		this.goodsItem = goodsItem;
	}
	
	public SellerOrder() {
		super();
	}

	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getoAddres() {
		return oAddres;
	}
	public void setoAddres(String oAddres) {
		this.oAddres = oAddres;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public boolean isoIsTake() {
		return oIsTake;
	}
	public void setoIsTake(boolean oIsTake) {
		this.oIsTake = oIsTake;
	}
	public double getoTotal() {
		return oTotal;
	}
	public void setoTotal(double oTotal) {
		this.oTotal = oTotal;
	}
	public Date getOdeliverDate() {
		return odeliverDate;
	}
	public void setOdeliverDate(Date odeliverDate) {
		this.odeliverDate = odeliverDate;
	}
	public boolean isoIsDeliver() {
		return oIsDeliver;
	}
	public void setoIsDeliver(boolean oIsDeliver) {
		this.oIsDeliver = oIsDeliver;
	}
	public List<Goods> getGoodsItem() {
		return goodsItem;
	}
	public void setGoodsItem(List<Goods> goodsItem) {
		this.goodsItem = goodsItem;
	}

	@Override
	public String toString() {
		return "SellerOrder [sId=" + sId + ", uId=" + uId + ", oAddres="
				+ oAddres + ", startdate=" + startdate + ", oIsTake=" + oIsTake
				+ ", oTotal=" + oTotal + ", odeliverDate=" + odeliverDate
				+ ", oIsDeliver=" + oIsDeliver + ", goodsItem=" + goodsItem
				+ "]";
	}
	
	
}
