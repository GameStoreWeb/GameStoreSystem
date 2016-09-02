package com.gss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gss.commons.JdbcUtils;
import com.gss.commons.Utils;
import com.gss.dao.AccountManage;
import com.gss.entity.User;

public class UserLoginManageImpl implements AccountManage {

	/* (non-Javadoc)
	 * @see com.gss.dao.LoginManage#checkLogin(java.lang.String, java.lang.String)
	 */
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
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.gss.dao.LoginManage#register(com.gss.entity.User)
	 */
	@Override
	public boolean register(Object object) {
		// TODO Auto-generated method stub
		User user = (User)object;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();
		//检查用户名是否存在
		String sql0 = "select * from customer where userName = ?";
		try {
			statement = connection.prepareStatement(sql0);
			statement.setString(1, user.getuLoginName());
			
			rs = statement.executeQuery();
			
			while (rs.next()) {
				return false;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		
		String customerNo = null;
		String num = null;
		
		//重新连接数据库
		connection = JdbcUtils.getConn();
		String sql = "select customerNo from customer";
		
		try {
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			
			//生成用户ID，格式为u+当前日期+序号，例如：u2016083103
			int count = 0;
			String date = Utils.getDate();
			while (rs.next()) {
				String id = rs.getString("customerNo");
				String tmp = id.substring(1, 9);
				if(tmp.equals(date))
					count++;
			}
			if(count < 10){
				num = "0" + count;
			}else {
				num = "" + count;
			}
			customerNo = "u" + date + num;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//添加新用户
		String sql2 = "insert into customer values(?, ?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql2);
			
			statement.setString(1, customerNo);
			statement.setString(2, user.getuPwd());
			statement.setString(3, user.getuName());
			statement.setString(4, user.getuSex());
			statement.setString(5, user.getuLoginName());
			statement.setString(6, user.getuTelephone());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String cartNo = "c" + customerNo;
		String sql3 = "insert into shoppingcart values(?, ?)";
		try {
			statement = connection.prepareStatement(sql3);
			
			statement.setString(1, cartNo);
			statement.setString(2, customerNo);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see com.gss.dao.LoginManage#showUnitInfo(java.lang.String)
	 */
	@Override
	public Object showUnitInfo(String id) {
		// TODO Auto-generated method stub
		User user = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();
		String sql = "select * from customer where customerNo = ?";
		
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, id);
			
			rs = statement.executeQuery();
			
			while (rs.next()) {
				String customerNo = rs.getString("customerNo");
				String password = rs.getString("password");
				String customerName = rs.getString("customerName");
				String sex = rs.getString("sex");
				String userName = rs.getString("userName");
				String telephone = rs.getString("telephone");
				
				user = new User(customerNo, password, userName, sex, customerName, telephone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		return (Object)user;
	}

	/* (non-Javadoc)
	 * @see com.gss.dao.LoginManage#modifyUnitInfo(java.lang.Object)
	 */
	@Override
	public void modifyUnitInfo(Object object) {
		// TODO Auto-generated method stub
		User user = (User)object;
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = JdbcUtils.getConn();
		String sql = "update customer set password = ?, customerName = ?, sex = ?, userName = ?, telephone = ? where customerNo = ?";
		
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getuPwd());
			statement.setString(2, user.getuName());
			statement.setString(3, user.getuSex());
			statement.setString(4, user.getuLoginName());
			statement.setString(5, user.getuTelephone());
			statement.setString(6, user.getuId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, null);
		}
	}
	

	/* (non-Javadoc)
	 * @see com.gss.dao.AccountManage#deleteAccount(java.lang.String)
	 */
	@Override
	public boolean deleteAccount(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
