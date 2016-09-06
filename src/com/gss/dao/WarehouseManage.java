package com.gss.dao;

import java.util.List;

import com.gss.entity.Goods;
import com.gss.entity.UserOrder;

public interface WarehouseManage {
	/**
	 * ����µ���Ʒ
	 * @param goods
	 */
	public void addGoods(Goods goods, int sellerid);

	/**
	 * ɾ����Ʒ
	 * @param goods
	 */
	public void deleteGoods(Goods goods,  int sellerid);
	
	/**
	 * �޸���Ʒ
	 * @param goods
	 */
	public void modifyGoods(Goods goods, int sellerid);
	
	
	/**
	 * ����
	 * @param id
	 */
	public void deliverGoods(String id,  int sellerid);
	
	/**
	 * ȡ������
	 * @param id
	 */
	public void cancelOrder(String id, int sellerid);
	
	/**
	 * չʾ���ж���
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
	 * ͨ����ƷID������Ʒ
	 * @param goodsid
	 * @return
	 */
	public Goods findGoodsById(int goodsid);
	
	/**
	 * �������Ų������
	 * @param id
	 * @return
	 */
	public String findCategoryById(String id);
	
	/**
	 * ���ݹؼ��ֲ�����Ʒ
	 * @param keyword
	 * @return
	 */
	public List<Goods> findGoodsByKw(String keyword);
	
	
	/**
	 * չʾ������Ʒ
	 * @return
	 */
	public List<Goods> showAllGoods();
	
	/**
	 * ������Ʒ������ͼƬ
	 * @param goodid
	 * @return
	 */
	public List<String> showAllGoodsImage(int goodid);
	
	/**
	 * չʾ�̼ҵ�������Ʒ
	 * @param sellerId
	 * @return
	 */
	public List<Goods> showSellerProducts(int sellerId);
	
}
