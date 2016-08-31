package com.gss.dao;

public interface iwarehouse {
	/**
	 * 添加新的商品
	 * @param goods
	 */
	void addGoods(Goods goods);

	/**
	 * 删除商品
	 * @param goods
	 */
	void deleteGoods(Goods goods);
	
	/**
	 * 修改商品
	 * @param goods
	 */
	void modifyGoods(Goods goods);
	
	
	/**
	 * 发货
	 * @param id
	 */
	void deliverGoods(String id);
	
	void cancealOrder(String id);
	
	UserOrder showAllOrdor(String id);
	
}
