package com.gss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gss.commons.JdbcUtils;
import com.gss.dao.AccountManage;
import com.gss.dao.CartManage;
import com.gss.dao.WarehouseManage;
import com.gss.entity.Cart;
import com.gss.entity.CartGoods;
import com.gss.entity.Goods;
import com.gss.entity.Seller;


public class CartManageImpl implements CartManage {

	@SuppressWarnings("resource")
	@Override
	public void addGoods(int goodsid, String userid, int quantity) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		int cartdetailid = -1;

		ResultSet rs = null;
		String cartNo = getCartId(userid);
		try {

			String sql = "SELECT id FROM cartdetails WHERE productNo=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, goodsid);
			rs = stat.executeQuery();
			while (rs.next()) {
				cartdetailid = rs.getInt(1);
			}

			if (cartdetailid < 0) {
				String sql2 = "INSERT INTO cartdetails (cartNo, productNo,quantity) VALUES (?, ?,?)";
				stat = conn.prepareStatement(sql2);
				stat.setString(1, cartNo);
				stat.setInt(2, goodsid);
				stat.setInt(3, quantity);
				stat.executeUpdate();
			} else {
				String sql2 = "UPDATE cartdetails SET quantity = quantity+? WHERE id = ? ";
				stat = conn.prepareStatement(sql2);

				stat.setInt(1, quantity);
				stat.setInt(2, cartdetailid);

				stat.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeDB(conn, stat, rs);
		}

	}

	@Override
	public void deleteGoods(int goodsId, String userId) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		String cartNo = getCartId(userId);
			
		try {
			String sql = "DELETE FROM cartdetails WHERE productNo = ? AND cartNo = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, goodsId);
			stat.setString(2, cartNo);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
		

	}

	@Override
	public void modifyGoods_in(int goodsId, String userId) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		String cartNo = getCartId(userId);
			
		try {
			String sql = "UPDATE cartdetails SET quantity =quantity+ ? WHERE cartNo = ? AND productNo=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, 1);
			stat.setString(2, cartNo);
			stat.setInt(3, goodsId);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
	}

	
	@Override
	public void modifyGoods_de(int goodsId, String userId) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		String cartNo = getCartId(userId);
			
		try {
			String sql = "UPDATE cartdetails SET quantity = quantity+ ? WHERE cartNo = ? AND productNo=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, 1);
			stat.setString(2, cartNo);
			stat.setInt(3, goodsId);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
	}
	
	
	@Override
	public String getCartId(String userid) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		ResultSet rs = null;
		String cartNo = null;

		try {
			String sql = "SELECT cartNo FROM shoppingcart WHERE customerNo=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, userid);
			rs = stat.executeQuery();
			while (rs.next()) {
				cartNo = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeDB(conn, stat, rs);
		}

		return cartNo;
	}
	
	
	@Override
	public Cart showAllCart(String userid) {
		Cart carts = new Cart();
		carts.setcUserId(userid);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		connection = JdbcUtils.getConn();
		List<CartGoods> cart = new ArrayList<CartGoods>();
		
		try {
			String sql = "select cartNo from shoppingcart WHERE customerNo = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userid);
			rs = statement.executeQuery();
			while (rs.next()) {
				carts.setCid(rs.getString("cartNo"));
			}
			
			String sql1 = "select * from cartdetails WHERE cartNo = ?";
			statement = connection.prepareStatement(sql1);
			statement.setString(1, carts.getCid());
			rs = statement.executeQuery();
			while (rs.next()) {
				int productid = rs.getInt("productNo");
				WarehouseManage wm = new WarehouseManageImpl();
				Goods goods = wm.findGoodsById(productid);
				int goodsQuantity = rs.getInt("quantity");
				CartGoods cartgoods = new  CartGoods(goods,goodsQuantity);
				cart.add(cartgoods);
			
			}
			carts.setGoodsItem(cart);
			
						
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carts;
	}

	@Override
	public float getTotalPrice(Cart cart){
		float total = 0;
		for (CartGoods goods : cart.getGoodsItem()) {
			total += goods.getGoodsQuantity()*goods.getGoods().getgPrice()*goods.getGoods().getgDiscount();
		}
		
		return total;
	}

	@Override
	public boolean isInCart(String userid, int goodsId) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		String cartNo = getCartId(userid);
		ResultSet rs = null;
			
		try {
			String sql = "SELECT cartdetails  WHERE cartNo = ? AND productNo=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, 1);
			stat.setString(2, cartNo);
			stat.setInt(3, goodsId);
			rs = stat.executeQuery();
			
			while(rs.next())
			{
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
			
		
		return flag;
	}


}
