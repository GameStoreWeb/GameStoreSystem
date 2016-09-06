package com.gss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gss.commons.JdbcUtils;
import com.gss.dao.AccountManage;
import com.gss.entity.Page;
import com.gss.entity.Seller;

public class SellerLoginManageImpl implements AccountManage {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gss.dao.LoginManage#checkLogin(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean checkLogin(String name, String pwd) {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(name);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean flag = false;

		connection = JdbcUtils.getConn();
		String sql = "select * from producer where producerNo = ? and password = ?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setInt(1, id);
			statement.setString(2, pwd);

			rs = statement.executeQuery();

			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeDB(connection, statement, rs);
		}

		return flag;
	}

	/* (non-Javadoc)
	 * @see com.gss.dao.AccountManage#register(java.lang.Object)
	 */
	@Override
	public boolean register(Object object) {
		// TODO Auto-generated method stub
		Seller seller = (Seller) object;
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = JdbcUtils.getConn();
		// 添加新商家
		String sql2 = "insert into producer(producerName, address, telephone, password) values(?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql2);

			statement.setString(1, seller.getsName());
			statement.setString(2, seller.getsAddress());
			statement.setString(3, seller.getsPhone());
			statement.setString(4, seller.getsPwd());

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, null);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gss.dao.LoginManage#showUnitInfo(java.lang.String)
	 */
	@Override
	public Object showUnitInfo(String id) {
		// TODO Auto-generated method stub
		int producerNo = Integer.parseInt(id);
		Seller seller = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		connection = JdbcUtils.getConn();
		String sql = "select * from producer where producerNo = ?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setInt(1, producerNo);

			rs = statement.executeQuery();

			while (rs.next()) {
				
				String producerName = rs.getString("producerName");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				String password = rs.getString("password");

				seller = new Seller(producerNo, producerName, address,
						telephone, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeDB(connection, statement, rs);
		}
		return (Object) seller;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gss.dao.LoginManage#modifyUnitInfo(java.lang.Object)
	 */
	@Override
	public void modifyUnitInfo(Object object) {
		// TODO Auto-generated method stub
		Seller seller = (Seller) object;
		Connection connection = null;
		PreparedStatement statement = null;

		connection = JdbcUtils.getConn();
		String sql = "update producer set producerName = ?, address = ?, telephone = ?, password = ? where producerNo = ?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setString(1, seller.getsName());
			statement.setString(2, seller.getsAddress());
			statement.setString(3, seller.getsPhone());
			statement.setString(4, seller.getsPwd());
			statement.setInt(5, seller.getsId());

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeDB(connection, statement, null);
		}
	}

	/* (non-Javadoc)
	 * @see com.gss.dao.AccountManage#deleteAccount(java.lang.String)
	 */
	@Override
	public boolean deleteAccount(String id) {
		// TODO Auto-generated method stub
		int producerNo = Integer.parseInt(id);
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = true;

		connection = JdbcUtils.getConn();
		String sql = "delete from producer where producerNo = ?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setInt(1, producerNo);

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} finally {
			JdbcUtils.closeDB(connection, statement, null);
		}
		return flag;
	}

	@Override
	public Page<Seller> findSellers(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Page<Seller> page = new Page<Seller>(pageNo, pageSize);
		List<Seller> list = new ArrayList<Seller>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		conn = JdbcUtils.getConn();
		try {
			stat = conn.prepareStatement("select count(*) from producer");
			
			rs = stat.executeQuery();
			while(rs.next()){
				page.setTotalCount(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "select * from producer limit ?, ?";
		try {
			stat = conn.prepareStatement(sql);
			
			stat.setInt(1, (page.getPageNo()-1)*pageSize);
			stat.setInt(2, pageSize);
			rs = stat.executeQuery();
			
			while(rs.next()){
				Seller seller = new Seller();
				seller.setsId(rs.getInt("producerNo"));
				seller.setsName(rs.getString("producerName"));
				seller.setsAddress(rs.getString("address"));
				seller.setsPhone(rs.getString("telephone"));
				seller.setsPwd(rs.getString("password"));
				list.add(seller);
			}
			page.setList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(conn, stat, rs);
		}
		
		return page;
	}

}
