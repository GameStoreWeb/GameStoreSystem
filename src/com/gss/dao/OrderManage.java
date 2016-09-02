package com.gss.dao;

import java.util.List;

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
	public UserOrder showUnitOrder(String id, String orderId);
	/**
	 * ȡ������
	 * @param id
	 * @param orderId
	 */
	public void cancelOrder(String id, String orderId);
}
