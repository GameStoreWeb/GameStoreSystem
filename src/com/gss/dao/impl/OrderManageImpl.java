package com.gss.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gss.commons.JdbcUtils;
import com.gss.commons.Utils;
import com.gss.dao.OrderManage;
import com.gss.entity.UserOrder;

public class OrderManageImpl implements OrderManage {

	@Override
	public void addOrder(UserOrder order) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		String orderNo = null;
		String num = null;
		
		connection = JdbcUtils.getConn();
		String sql = "select orderNo from order";
		
		try {
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			
			//生成订单ID，格式为o+当前日期+序号，例如：o2016090101
			int count = 0;
			String date = Utils.getDate();
			while (rs.next()) {
				String oNo = rs.getString("orderNo");
				String tmp = oNo.substring(1, 9);
				if(tmp.equals(date))
					count++;
			}
			if(count < 10){
				num = "0" + count;
			}else {
				num = "" + count;
			}
			orderNo = "o" + date + num;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//添加新订单
		String sql2 = "insert into oder values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql2);

			statement.setString(1, orderNo);
			statement.setString(2, order.getsId());
			statement.setString(3, order.getoAddress());
			statement.setDate(4, new Date(order.getStartDate().getTime()));
			statement.setDouble(5, order.getoTotal());
			statement.setDate(6, new Date(order.getoDeliverDate().getTime()));
			statement.setBoolean(7, order.isoIsDeliver());
			statement.setBoolean(8, order.isoIsTake());

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//设置新的订单项
		String sql3 = "isnert into orderdetails(orderNo, productNo, quantity, price) values(?, ?, ?, ?)";
		try {
			for(int i=0; i<order.getGoodsItem().size(); i++){
				statement = connection.prepareStatement(sql3);
				
				statement.setString(1, orderNo);
				statement.setInt(2, order.getGoodsItem().get(i).getgId());
				statement.setInt(2, order.getGoodsQuantity().get(i));
				
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		
	}

	@Override
	public List<UserOrder> showAllOrders(String id) {
		// TODO Auto-generated method stub
		List<UserOrder> userOrders = new ArrayList<UserOrder>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();
		//查询订单表
		String sql = "select * from order where customerNo = ?";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, id);
			rs = statement.executeQuery();
			
			while (rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserOrder showUnitOrder(String id, String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelOrder(String id, String orderId) {
		// TODO Auto-generated method stub

	}

}
