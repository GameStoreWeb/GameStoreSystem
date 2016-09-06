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
	 * ������Ʒ����
	 * @param goodsId
	 * @param userId
	 * @param amount
	 */
	public void modifyGoods_in(int goodsId, String userId);
	
	/**
	 * ������Ʒ����
	 * @param goodsId
	 * @param userId
	 * @param amount
	 */
	public void modifyGoods_de(int goodsId, String userId);

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
