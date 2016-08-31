package com.gss.entity;

import java.util.List;

/**
 * @author Joker
 * 购物车类，包含购物车号、用户ID、车内商品三个属性
 */
public class Cart {
	private String cId;
	private String cUserId;
	private List<Goods> goodsItem;
	
	public Cart(String cId, String cUserId, List<Goods> goodsItem) {
		super();
		this.cId = cId;
		this.cUserId = cUserId;
		this.goodsItem = goodsItem;
	}
	
	public Cart() {
		super();
	}

	public String getCid() {
		return cId;
	}
	public void setCid(String cId) {
		this.cId = cId;
	}
	public String getcUserId() {
		return cUserId;
	}
	public void setcUserId(String cUserId) {
		this.cUserId = cUserId;
	}
	public List<Goods> getGoodsItem() {
		return goodsItem;
	}
	public void setGoodsItem(List<Goods> goodsItem) {
		this.goodsItem = goodsItem;
	}

	@Override
	public String toString() {
		return "Cart [cId=" + cId + ", cUserId=" + cUserId + ", goodsItem="
				+ goodsItem + "]";
	}
	
	
}
