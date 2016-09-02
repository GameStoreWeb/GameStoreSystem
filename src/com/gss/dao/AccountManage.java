package com.gss.dao;

public interface AccountManage {
	/**
	 * 检查登录
	 * @param name
	 * @param pwd
	 * @return
	 */
	public boolean checkLogin(String name, String pwd);
	/**
	 * 用户注册
	 * @param user
	 */
	public boolean register(Object object);
	/**
	 * 展示个人信息
	 * @param id
	 * @return
	 */
	public Object showUnitInfo(String id);
	/**
	 * 修改个人信息
	 * @param object
	 */
	public void modifyUnitInfo(Object object);
	/**
	 * 删除账户
	 * @param id
	 * @return
	 */
	public boolean deleteAccount(String id);
}
