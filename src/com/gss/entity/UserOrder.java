package com.gss.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Joker
 * 用户订单类，包含以下属性：
 * 订单ID、用户ID、收货地址、订单日期、
 * 是否发货、订单总额、发货日期、是否发货、购买商品
 */
public class UserOrder {
	private String oId;
	private String sId;
	private String oAddress;
	private Date startDate;
	private boolean oIsTake;
	private double oTotal;
	private Date oDeliverDate;
	private boolean oIsDeliver;
	private List<Goods> goodsItem;
	
	public UserOrder(String oId, String sId, String oAddress, Date startDate,
			boolean oIsTake, double oTotal, Date oDeliverDate,
			boolean oIsDeliver, List<Goods> goodsItem) {
		super();
		this.oId = oId;
		this.sId = sId;
		this.oAddress = oAddress;
		this.startDate = startDate;
		this.oIsTake = oIsTake;
		this.oTotal = oTotal;
		this.oDeliverDate = oDeliverDate;
		this.oIsDeliver = oIsDeliver;
		this.goodsItem = goodsItem;
	}
	
	public UserOrder() {
		super();
	}

	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getoAddress() {
		return oAddress;
	}
	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	public Date getoDeliverDate() {
		return oDeliverDate;
	}
	public void setoDeliverDate(Date oDeliverDate) {
		this.oDeliverDate = oDeliverDate;
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
		return "UserOrder [oId=" + oId + ", sId=" + sId + ", oAddress="
				+ oAddress + ", startDate=" + startDate + ", oIsTake="
				+ oIsTake + ", oTotal=" + oTotal + ", oDeliverDate="
				+ oDeliverDate + ", oIsDeliver=" + oIsDeliver + ", goodsItem="
				+ goodsItem + "]";
	}
	
	
}
