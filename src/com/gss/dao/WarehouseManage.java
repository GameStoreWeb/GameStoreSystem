package com.gss.dao;

import java.awt.Image;
import java.util.List;

import com.gss.entity.Goods;
import com.gss.entity.SellerOrder;

public interface WarehouseManage {
	/**
	 * 添加新的商品
	 * @param goods
	 */
	public void addGoods(Goods goods, String sellerid);

	/**
	 * 删除商品
	 * @param goods
	 */
	public void deleteGoods(Goods goods,  String sellerid);
	
	/**
	 * 修改商品
	 * @param goods
	 */
	public void modifyGoods(Goods goods, String sellerid);
	
	
	/**
	 * 发货
	 * @param id
	 */
	public void deliverGoods(String id,  String sellerid);
	
	/**
	 * 取消订单
	 * @param id
	 */
	public void cancelOrder(String id, String sellerid);
	
	/**
	 * 展示所有订单
	 * @param id
	 * @return
	 */
	public SellerOrder showAllOrder(String id);
	
	/**
	 * @param Category
	 * @return
	 */
	public void newCategory(String Category);
	
	/**
	 * @param images
	 */
	public void newProducting(List<Image> images);
	
}
