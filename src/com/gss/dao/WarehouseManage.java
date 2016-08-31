package com.gss.dao;

import com.gss.entity.Goods;
import com.gss.entity.SellerOrder;

public interface WarehouseManage {
	/**
	 * 添加新的商品
	 * @param goods
	 */
	public void addGoods(Goods goods);

	/**
	 * 删除商品
	 * @param goods
	 */
	public void deleteGoods(Goods goods);
	
	/**
	 * 修改商品
	 * @param goods
	 */
	public void modifyGoods(Goods goods);
	
	
	/**
	 * 发货
	 * @param id
	 */
	public void deliverGoods(String id);
	
	/**
	 * 取消订单
	 * @param id
	 */
	public void cancelOrder(String id);
	
	/**
	 * 展示所有订单
	 * @param id
	 * @return
	 */
	public SellerOrder showAllOrder(String id);
	
}
