package com.gss.dao;

public interface iwarehouse {
	/**
	 * ����µ���Ʒ
	 * @param goods
	 */
	void addGoods(Goods goods);

	/**
	 * ɾ����Ʒ
	 * @param goods
	 */
	void deleteGoods(Goods goods);
	
	/**
	 * �޸���Ʒ
	 * @param goods
	 */
	void modifyGoods(Goods goods);
	
	
	/**
	 * ����
	 * @param id
	 */
	void deliverGoods(String id);
	
	void cancealOrder(String id);
	
	UserOrder showAllOrdor(String id);
	
}
