package com.gss.dao;

import java.util.List;

import com.gss.entity.Cart;


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
	 * 增加商品数量
	 * @param goodsId
	 * @param userId
	 * @param amount
	 */
	public void modifyGoods_in(int goodsId, String userId);
	
	/**
	 * 减少商品数量
	 * @param goodsId
	 * @param userId
	 * @param amount
	 */
	public void modifyGoods_de(int goodsId, String userId);

	/**
	 * 获取用户的购物车主键
	 * @param userid
	 * @return用户的购物车主键
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
