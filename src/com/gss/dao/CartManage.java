package com.gss.dao;

import com.gss.entity.Goods;

public interface CartManage {
	/**
	 * 添加商品到购物车
	 * @param goods
	 * 
	 */
	public void addGoods(String goodsid, String userid, int quantity);
	/**
	 * 从购物车删除商品
	 * @param goodsId
	 * @param userId
	 */
	public void deleteGoods(String goodsId, String userId);
	/**
	 * 修改购物车中商品数量
	 * @param goodsId
	 * @param userId
	 * @param amount
	 */
	public void modifyGoods(String goodsId, String userId, int amount);
	

	/**
	 * 获取用户的购物车主键
	 * @param userid
	 * @return用户的购物车主键
	 */
	public String getCartId(String userid);
}
