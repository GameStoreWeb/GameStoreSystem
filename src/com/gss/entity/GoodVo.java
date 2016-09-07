package com.gss.entity;


public class GoodVo {
	private Goods goodsItem;
	private Integer goodsQuantity;
	public Goods getGoodsItem() {
		return goodsItem;
	}
	public void setGoodsItem(Goods goodsItem) {
		this.goodsItem = goodsItem;
	}
	public Integer getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(Integer goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}
	@Override
	public String toString() {
		return "GoodVo [goodsItem=" + goodsItem + ", goodsQuantity="
				+ goodsQuantity + "]";
	}
	public GoodVo() {
		super();
	}
	public GoodVo(Goods goodsItem, Integer goodsQuantity) {
		super();
		this.goodsItem = goodsItem;
		this.goodsQuantity = goodsQuantity;
	}
}
