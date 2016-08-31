package com.gss.dao;

import com.gss.entity.User;

public interface LoginManage {
	/**
	 * ����¼
	 * @param name
	 * @param pwd
	 * @return
	 */
	public boolean checkLogin(String name, String pwd);
	/**
	 * �û�ע��
	 * @param user
	 */
	public void register(User user);
	/**
	 * չʾ������Ϣ
	 * @param id
	 * @return
	 */
	public Object showUnitInfo(String id);
	/**
	 * �޸ĸ�����Ϣ
	 * @param object
	 */
	public void modifyUnitInfo(Object object);
}
