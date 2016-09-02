package com.gss.dao;

import java.awt.Image;
import java.util.List;

import com.gss.entity.Goods;
import com.gss.entity.SellerOrder;
import com.gss.entity.UserOrder;

public interface WarehouseManage {
	/**
	 * ����µ���Ʒ
	 * @param goods
	 */
	public void addGoods(Goods goods, String sellerid);

	/**
	 * ɾ����Ʒ
	 * @param goods
	 */
	public void deleteGoods(int goodsid);
	
	/**
	 * �޸���Ʒ
	 * @param goods
	 */
	public void modifyGoods(Goods goods, int sales);
	
	
	/**
	 * ����
	 * @param id
	 */
	public void deliverGoods(int orderid);
	
	/**
	 * ȡ������
	 * @param id
	 */
	public void cancelOrder(int id, int sellerid);
	
	/**
	 * չʾ���ж���
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
