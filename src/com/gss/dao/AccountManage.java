package com.gss.dao;

public interface AccountManage {
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
	public boolean register(Object object);
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
	/**
	 * ɾ���˻�
	 * @param id
	 * @return
	 */
	public boolean deleteAccount(String id);
}
