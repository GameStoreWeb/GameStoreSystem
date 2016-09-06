package com.gss.dao;

import java.util.List;

import com.gss.entity.Goods;
import com.gss.entity.UserOrder;

public interface WarehouseManage {
	/**
	 * 添加新的商品
	 * @param goods
	 */
	public void addGoods(Goods goods, int sellerid);

	/**
	 * 删除商品
	 * @param goods
	 */
	public void deleteGoods(Goods goods,  int sellerid);
	
	/**
	 * 修改商品
	 * @param goods
	 */
	public void modifyGoods(Goods goods, int sellerid);
	
	
	/**
	 * 发货
	 * @param id
	 */
	public void deliverGoods(String id,  int sellerid);
	
	/**
	 * 取消订单
	 * @param id
	 */
	public void cancelOrder(String id, int sellerid);
	
	/**
	 * 展示所有订单
	 * @param id
	 * @return
	 */
	public List<UserOrder> showAllOrder(int id);
	
	/**
	 * @param Category
	 * @return
	 */
	public void newCategory(String Category);
	
	/**
	 * @param images
	 */
	public void newProducting(List<String> images , int productid);
	
	/**
	 * 通过商品ID查找商品
	 * @param goodsid
	 * @return
	 */
	public Goods findGoodsById(int goodsid);
	
	/**
	 * 根据类别号查找类别
	 * @param id
	 * @return
	 */
	public String findCategoryById(String id);
	
	/**
	 * 根据关键字查找商品
	 * @param keyword
	 * @return
	 */
	public List<Goods> findGoodsByKw(String keyword);
	
	
	/**
	 * 展示所有商品
	 * @return
	 */
	public List<Goods> showAllGoods();
	
	/**
	 * 搜索商品的所有图片
	 * @param goodid
	 * @return
	 */
	public List<String> showAllGoodsImage(int goodid);
	
	/**
	 * 展示商家的所有商品
	 * @param sellerId
	 * @return
	 */
	public List<Goods> showSellerProducts(int sellerId);
	
}
