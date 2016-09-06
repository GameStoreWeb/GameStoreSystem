package com.gss.dao;

import java.util.List;

import com.gss.entity.Cart;


public interface CartManage {
	/**
	 * �����Ʒ�����ﳵ
	 * @param goods
	 * 
	 */
	public void addGoods(int goodsid, String userid, int quantity);
	/**
	 * �ӹ��ﳵɾ����Ʒ
	 * @param goodsId
	 * @param userId
	 */
	public void deleteGoods(int goodsId, String userId);
	/**
	 * �޸Ĺ��ﳵ����Ʒ����
	 * @param goodsId
	 * @param userId
	 * @param amount
	 */
	public void modifyGoods(int goodsId, String userId, int amount);
	

	/**
	 * ��ȡ�û��Ĺ��ﳵ����
	 * @param userid
	 * @return�û��Ĺ��ﳵ����
	 */
	public String getCartId(String userid);
	
	/**
	 * @param userid
	 * @return
	 */
	public Cart showAllCart(String userid);
	
	/**
	 * @param userid
	 * @return
	 */
	public float getTotalPrice(Cart cart);
}
