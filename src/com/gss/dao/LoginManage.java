package com.gss.dao;

import com.gss.entity.User;

public interface LoginManage {
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
	public void register(User user);
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
}
