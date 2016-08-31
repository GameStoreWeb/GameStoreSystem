package com.gss.dao;

import com.gss.entity.Goods;
import com.gss.entity.SellerOrder;

public interface WarehouseManage {
	/**
	 * ����µ���Ʒ
	 * @param goods
	 */
	public void addGoods(Goods goods);

	/**
	 * ɾ����Ʒ
	 * @param goods
	 */
	public void deleteGoods(Goods goods);
	
	/**
	 * �޸���Ʒ
	 * @param goods
	 */
	public void modifyGoods(Goods goods);
	
	
	/**
	 * ����
	 * @param id
	 */
	public void deliverGoods(String id);
	
	/**
	 * ȡ������
	 * @param id
	 */
	public void cancelOrder(String id);
	
	/**
	 * չʾ���ж���
	 * @param id
	 * @return
	 */
	public SellerOrder showAllOrder(String id);
	
}
