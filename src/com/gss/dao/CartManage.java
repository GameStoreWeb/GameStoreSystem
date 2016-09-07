package com.gss.dao;

import com.gss.entity.Cart;
import com.gss.entity.CartDetails;
import com.gss.entity.Goods;


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
	
	
	/**
	 * @param userid
	 * @param goodsId
	 * @return
	 */
	public boolean isInCart(String userid,int goodsId);
	/**
	 * 获取购物车里某个商品
	 * @param userId
	 * @param goodsId
	 * @return
	 */
	public CartDetails getCartDetailsById(String userId,int goodsId);
	/**
	 * 修个某个购物车的商品
	 * @param userId
	 * @param goods
	 */
	public void updateCartDetails(CartDetails cartDetails);
	
	/**
	 * 清空购物车
	 * @param userId
	 */
	public void clearCart(String userId);
}
