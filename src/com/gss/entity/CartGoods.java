package com.gss.entity;


public class CartGoods{
	private Goods goods;
	private int goodsQuantity;
	
	public CartGoods() {
		super();
	}

	public CartGoods(Goods goods, int goodsQuantity) {
		super();
		this.goods = goods;
		this.goodsQuantity = goodsQuantity;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getGoodsQuantity() {
		return goodsQuantity;
	}

	public void setGoodsQuantity(int goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}

	@Override
	public String toString() {
		return "CartGoods [goods=" + goods + ", goodsQuantity=" + goodsQuantity
				+ "]";
	}

	
	
}
