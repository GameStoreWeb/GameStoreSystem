package com.gss.dao;


public interface CartManage {
	/**
	 * 添加商品到购物车
	 * @param goods
	 * 
	 */
	public void addGoods(int goodsid, String userid, int quantity);
	/**
	 * 从购物车删除商品
	 * @param goodsId
	 * @param userId
	 */
	public void deleteGoods(int goodsId, String userId);
	/**
	 * 修改购物车中商品数量
	 * @param goodsId
	 * @param userId
	 * @param amount
	 */
	public void modifyGoods(int goodsId, String userId, int amount);
	

	/**
	 * 获取用户的购物车主键
	 * @param userid
	 * @return用户的购物车主键
	 */
	public String getCartId(String userid);
}
