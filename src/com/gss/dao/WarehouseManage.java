package com.gss.dao;

import java.awt.Image;
import java.util.List;

import com.gss.entity.Goods;
import com.gss.entity.SellerOrder;
import com.gss.entity.UserOrder;

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
	public void deleteGoods(int goodsid);
	
	/**
	 * 修改商品
	 * @param goods
	 */
	public void modifyGoods(Goods goods, int sales);
	
	
	/**
	 * 发货
	 * @param id
	 */
	public void deliverGoods(int orderid);
	
	/**
	 * 取消订单
	 * @param id
	 */
	public void cancelOrder(int id, int sellerid);
	
	/**
	 * 展示所有订单
	 * @param id
	 * @return
	 */
	public List<UserOrder> showAllOrder(String id);
	
	/**
	 * @param Category
	 * @return
	 */
	public void newCategory(String Category);
	
	/**
	 * @param images
	 */
	public void newProducting(List<String> images , int productid);
	
	public Goods findGoodsById(int goodsid);
	
//	public String findCategoryById(int id);
	public int findSellerByOrderId(int id);
	
}
