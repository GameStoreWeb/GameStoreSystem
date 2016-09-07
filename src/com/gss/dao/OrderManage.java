package com.gss.dao;

import java.util.List;

import com.gss.entity.GoodsComment;
import com.gss.entity.UserOrder;

public interface OrderManage {
	/**
	 * 生成新的订单
	 * @param order
	 */
	public void addOrder(UserOrder order);
	/**
	 * 展示所有订单
	 * @param id
	 * @return
	 */
	public List<UserOrder> showAllOrders(String id);
	/**
	 * 展示单个订单详情
	 * @param id
	 * @param orderId
	 * @return
	 */
	public UserOrder showUnitOrder(String orderId);
	/**
	 * 取消订单
	 * @param id
	 * @param orderId
	 */
	public void cancelOrder(String id, String orderId);
	
	/**
	 * 通过关键字搜索订单
	 * @param keyword
	 * @return
	 */
	public List<UserOrder> findOrdersByKw(String id, String keyword);
	
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	public boolean addComment(GoodsComment comment);
	
	/**
	 * 获取商品的所有评论
	 * @param goodsId
	 * @return
	 */
	public List<GoodsComment> findComments(int goodsId);
}
