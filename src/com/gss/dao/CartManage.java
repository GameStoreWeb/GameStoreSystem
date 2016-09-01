package com.gss.dao;

import com.gss.entity.Goods;

public interface CartManage {
	/**
	 * �����Ʒ�����ﳵ
	 * @param goods
	 * 
	 */
	public void addGoods(String goodsid, String userid, int quantity);
	/**
	 * �ӹ��ﳵɾ����Ʒ
	 * @param goodsId
	 * @param userId
	 */
	public void deleteGoods(String goodsId, String userId);
	/**
	 * �޸Ĺ��ﳵ����Ʒ����
	 * @param goodsId
	 * @param userId
	 * @param amount
	 */
	public void modifyGoods(String goodsId, String userId, int amount);
	

	/**
	 * ��ȡ�û��Ĺ��ﳵ����
	 * @param userid
	 * @return�û��Ĺ��ﳵ����
	 */
	public String getCartId(String userid);
}
