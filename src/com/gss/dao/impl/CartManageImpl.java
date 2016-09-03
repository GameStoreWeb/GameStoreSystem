package com.gss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gss.commons.JdbcUtils;
import com.gss.dao.CartManage;


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
			while(rs.next())
			{
				cartdetailid = rs.getInt(1);
			}
			
			if(cartdetailid < 0){
				String sql2 = "INSERT INTO cartdetails (cartNo, productNo,quantity) VALUES (?, ?,?)";
				stat = conn.prepareStatement(sql2);
				stat.setString(1, cartNo);
				stat.setInt(2, goodsid);
				stat.setInt(3, quantity);
				stat.executeUpdate();
			}
			else
			{
				String sql2 = "UPDATE cartdetails SET quantity = quantity+? WHERE id = ? ";
				stat = conn.prepareStatement(sql2);
				
				stat.setInt(1, quantity);
				stat.setInt(2, cartdetailid);
				
				stat.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally
		{
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
	public void modifyGoods(int goodsId, String userId, int amount) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		String cartNo = getCartId(userId);
			
		try {
			String sql = "UPDATE cartdetails SET quantity = ? WHERE cartNo = ? AND productNo=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, amount);
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
			while(rs.next())
			{
				cartNo = rs.getString(1);
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, rs);
		}
			
		return cartNo;
	}

}
