package com.gss.entity;

import java.util.Date;
import java.util.List;

public class OrderVo {
	private String oId;
	private String sId;
	private String oAddress;
	private Date startDate;
	private boolean oIsTake;
	private double oTotal;
	private Date oDeliverDate;
	private boolean oIsDeliver;
	
	private List<GoodVo> goodVos;
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
	public String getDeliverStr(){
		if(oIsDeliver){
			return "已发货";
		}else if(oIsDeliver){
			return "待发货";
		}else{
			return "未知状态";
		}
	}
	public void setoIsDeliver(boolean oIsDeliver) {
		this.oIsDeliver = oIsDeliver;
	}
	public List<GoodVo> getGoodVos() {
		return goodVos;
	}
	public void setGoodVos(List<GoodVo> goodVos) {
		this.goodVos = goodVos;
	}
	public OrderVo() {
		super();
	}
	public OrderVo(String oId, String sId, String oAddress, Date startDate,
			boolean oIsTake, double oTotal, Date oDeliverDate,
			boolean oIsDeliver, List<GoodVo> goodVos) {
		super();
		this.oId = oId;
		this.sId = sId;
		this.oAddress = oAddress;
		this.startDate = startDate;
		this.oIsTake = oIsTake;
		this.oTotal = oTotal;
		this.oDeliverDate = oDeliverDate;
		this.oIsDeliver = oIsDeliver;
		this.goodVos = goodVos;
	}
	@Override
	public String toString() {
		return "OrderVo [oId=" + oId + ", sId=" + sId + ", oAddress="
				+ oAddress + ", startDate=" + startDate + ", oIsTake="
				+ oIsTake + ", oTotal=" + oTotal + ", oDeliverDate="
				+ oDeliverDate + ", oIsDeliver=" + oIsDeliver + ", goodVos="
				+ goodVos + "]";
	}
	
}
