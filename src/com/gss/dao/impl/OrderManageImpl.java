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
import com.gss.dao.WarehouseManage;
import com.gss.entity.Goods;
import com.gss.entity.GoodsComment;
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
				UserOrder order = new UserOrder();
				order.setoId(rs.getString("orderNo"));
				order.setsId(rs.getString("customerNo"));
				order.setoAddress(rs.getString("address"));
				order.setStartDate(new java.util.Date(rs.getDate("orderdate").getTime()));
				order.setoTotal(rs.getDouble("amount"));
				order.setoDeliverDate(new java.util.Date(rs.getDate("sendDate").getTime()));
				order.setoIsDeliver(rs.getBoolean("hasSend"));
				order.setoIsTake(rs.getBoolean("hasReceive"));
				
				userOrders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//查询订单详情
		String sql2 = "select * from orderdetails where orderNo = ?";
		try {
			statement = connection.prepareStatement(sql2);
			List<Goods> goods = new ArrayList<Goods>();
			List<Integer> quantity = new ArrayList<Integer>();
			for (UserOrder userOrder : userOrders) {
				statement.setString(1, userOrder.getoId());
				rs = statement.executeQuery();
				
				while (rs.next()) {
					WarehouseManage wm = new WarehouseManageImpl();
					Goods good = wm.findGoodsById(rs.getInt("productNo"));
					goods.add(good);
					quantity.add(rs.getInt("quantity"));
				}
				userOrder.setGoodsItem(goods);
				userOrder.setGoodsQuantity(quantity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		return userOrders;
	}

	@Override
	public UserOrder showUnitOrder(String id, String orderId) {
		// TODO Auto-generated method stub
		UserOrder order = new UserOrder();
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
				order.setoId(rs.getString("orderNo"));
				order.setsId(rs.getString("customerNo"));
				order.setoAddress(rs.getString("address"));
				order.setStartDate(new java.util.Date(rs.getDate("orderdate").getTime()));
				order.setoTotal(rs.getDouble("amount"));
				order.setoDeliverDate(new java.util.Date(rs.getDate("sendDate").getTime()));
				order.setoIsDeliver(rs.getBoolean("hasSend"));
				order.setoIsTake(rs.getBoolean("hasReceive"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//查询订单详情
		String sql2 = "select * from orderdetails where orderNo = ?";
		try {
			statement = connection.prepareStatement(sql2);
			statement.setString(1, order.getoId());
			
			rs = statement.executeQuery();
			List<Goods> goods = new ArrayList<Goods>();
			List<Integer> quantity = new ArrayList<Integer>();
			while (rs.next()) {
				WarehouseManage wm = new WarehouseManageImpl();
				Goods good = wm.findGoodsById(rs.getInt("productNo"));
				goods.add(good);
				quantity.add(rs.getInt("quantity"));
			}
			order.setGoodsItem(goods);
			order.setGoodsQuantity(quantity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		
		return order;
	}

	@Override
	public void cancelOrder(String id, String orderId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = JdbcUtils.getConn();
		
		//更新订单内容，设置isDeliver=false，isTake=true表示订单已取消
		String sql = "update order set hasSend = 0, hasReceive = 1 where orderNo = ? and customerNo = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, orderId);
			statement.setString(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, null);
		}
	}

	@Override
	public List<UserOrder> findOrdersByKw(String id, String keyword) {
		// TODO Auto-generated method stub
		List<UserOrder> userOrders = new ArrayList<UserOrder>();
		List<String> list = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();
		//按关键字搜索订单
		String sql = "select orderNo from orderdetails where productNo in (select productNo from product where productName like ? or (select producerName from producer where producerNo = product.producerNo) like ?)";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, "%" + keyword + "%");
			statement.setString(2, "%" + keyword + "%");
			rs = statement.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString("orderNo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		
		OrderManage om = new OrderManageImpl();
		for (String string : list) {
			UserOrder order = (UserOrder)om.showUnitOrder(id, string);
			userOrders.add(order);
		}
		return userOrders;
	}

	@Override
	public boolean addComment(GoodsComment comment) {
		// TODO Auto-generated method stub
		boolean flag = true;
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = JdbcUtils.getConn();
		String sql = "insert into review(customerNo, productNo, reviewContent, reviewdate) values(?, ?, ?, ?)";
		
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, comment.getcUser());
			statement.setInt(2, comment.getcGoodId());
			statement.setString(3, comment.getcDetail());
			statement.setDate(4, new Date(comment.getcDate().getTime()));
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, null);
		}
		return flag;
	}

	@Override
	public List<GoodsComment> findComments(int goodsId) {
		// TODO Auto-generated method stub
		List<GoodsComment> comments = new ArrayList<GoodsComment>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();
		String sql = "select * from review where productNo = ?";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, goodsId);
			rs = statement.executeQuery();
			
			while (rs.next()) {
				GoodsComment comment = new GoodsComment();
				comment.setcId(rs.getInt("reviewNo"));
				comment.setcGoodId(goodsId);
				comment.setcUser(rs.getString("customerNo"));
				comment.setcDetail(rs.getString("reviewContent"));
				comment.setcDate(new java.util.Date(rs.getDate("reviewdate").getTime()));
				
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		return comments;
	}
	
	

}
