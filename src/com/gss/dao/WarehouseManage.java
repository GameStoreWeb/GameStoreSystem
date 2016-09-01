package com.gss.dao;

import java.awt.Image;
import java.util.List;

import com.gss.entity.Goods;
import com.gss.entity.SellerOrder;

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
	public void deleteGoods(Goods goods,  String sellerid);
	
	/**
	 * �޸���Ʒ
	 * @param goods
	 */
	public void modifyGoods(Goods goods, String sellerid);
	
	
	/**
	 * ����
	 * @param id
	 */
	public void deliverGoods(String id,  String sellerid);
	
	/**
	 * ȡ������
	 * @param id
	 */
	public void cancelOrder(String id, String sellerid);
	
	/**
	 * չʾ���ж���
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
