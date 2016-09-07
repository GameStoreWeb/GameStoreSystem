package com.gss.dao;

import java.util.List;

import com.gss.entity.GoodsComment;
import com.gss.entity.UserOrder;

public interface OrderManage {
	/**
	 * �����µĶ���
	 * @param order
	 */
	public void addOrder(UserOrder order);
	/**
	 * չʾ���ж���
	 * @param id
	 * @return
	 */
	public List<UserOrder> showAllOrders(String id);
	/**
	 * չʾ������������
	 * @param id
	 * @param orderId
	 * @return
	 */
	public UserOrder showUnitOrder(String orderId);
	/**
	 * ȡ������
	 * @param id
	 * @param orderId
	 */
	public void cancelOrder(String id, String orderId);
	
	/**
	 * ͨ���ؼ�����������
	 * @param keyword
	 * @return
	 */
	public List<UserOrder> findOrdersByKw(String id, String keyword);
	
	/**
	 * �������
	 * @param comment
	 * @return
	 */
	public boolean addComment(GoodsComment comment);
	
	/**
	 * ��ȡ��Ʒ����������
	 * @param goodsId
	 * @return
	 */
	public List<GoodsComment> findComments(int goodsId);
}
