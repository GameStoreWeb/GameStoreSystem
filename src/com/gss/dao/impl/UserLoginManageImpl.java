package com.gss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gss.commons.JdbcUtils;
import com.gss.dao.LoginManage;
import com.gss.entity.User;

public class UserLoginManageImpl implements LoginManage {

	@Override
	public boolean checkLogin(String name, String pwd) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean flag = false;
		
		connection = JdbcUtils.getConn();
		String sql = "select * from customer where userName = ? and password = ?";
		
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, name);
			statement.setString(2, pwd);
			
			rs = statement.executeQuery();
			
			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();
		String sql = "select * from customer where userName = ? and password = ?";
	}

	@Override
	public Object showUnitInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyUnitInfo(Object object) {
		// TODO Auto-generated method stub

	}

}
