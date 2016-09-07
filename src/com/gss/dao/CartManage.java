package com.gss.dao;

import com.gss.entity.Cart;
import com.gss.entity.CartDetails;
import com.gss.entity.Goods;


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
	
	
	/**
	 * @param userid
	 * @param goodsId
	 * @return
	 */
	public boolean isInCart(String userid,int goodsId);
	/**
	 * ��ȡ���ﳵ��ĳ����Ʒ
	 * @param userId
	 * @param goodsId
	 * @return
	 */
	public CartDetails getCartDetailsById(String userId,int goodsId);
	/**
	 * �޸�ĳ�����ﳵ����Ʒ
	 * @param userId
	 * @param goods
	 */
	public void updateCartDetails(CartDetails cartDetails);
	
	/**
	 * ��չ��ﳵ
	 * @param userId
	 */
	public void clearCart(String userId);
}
