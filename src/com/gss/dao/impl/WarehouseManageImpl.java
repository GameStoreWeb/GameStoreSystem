package com.gss.dao.impl;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.gss.commons.JdbcUtils;
import com.gss.dao.WarehouseManage;
import com.gss.entity.Goods;
import com.gss.entity.SellerOrder;

public class WarehouseManageImpl implements WarehouseManage {


	@Override
	public void addGoods(Goods goods, String sellerid) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		int Categoryid = findIDByCategoryname(goods.getgCategory());
		if(Categoryid ==-1) 
		{
			newCategory(goods.getgCategory());
			Categoryid = findIDByCategoryname(goods.getgCategory());
		}
		
		try {
			String sql = "INSERT INTO product (productName,typeNo,describe,standard,price,producerNo,image,discount,sales) VALUES (?,?,?,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, goods.getgName());
			stat.setInt(2, Categoryid);
			stat.setString(3, goods.getgDetail());
			stat.setString(4, goods.getgStandard());
			stat.setDouble(5, goods.getgPrice());
			stat.setString(6, sellerid);
			stat.setInt(7, goods.getgPicture());
			stat.setString(8, cartNo);
			stat.setString(9, goodsId);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}

	}

	@Override
	public void deleteGoods(Goods goods, String sellerid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyGoods(Goods goods, String sellerid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliverGoods(String id, String sellerid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelOrder(String id, String sellerid) {
		// TODO Auto-generated method stub

	}

	@Override
	public SellerOrder showAllOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据种类名称查找id号
	 * @param Category
	 * @return -1 ：没有找到  其他：找到
	 */
	public int findIDByCategoryname(String Category) {
		int id = -1;
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		ResultSet rs = null;
		
		try {
			String sql = "SELECT protypeNo FROM protype WHERE protypeName = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, Category);
			rs = stat.executeQuery();
			while(rs.next())
			{
				id = rs.getInt(1);
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, rs);
		}
			
		
		return id;
	}
	
	public void newCategory(String Category) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		
		try {
			String sql = "INSERT INTO protype (protypeName) VALUES(?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, Category);
			stat.executeUpdate();
		
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
			
		
	
	}
	
	
	public void newProducting(List<Image> images) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		
		try {
			String sql = "INSERT INTO productimg (smallImg,bigImg1,bigImg2,bigImg3,bigImg) VALUES(?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, images.get(0).);
			stat.setString(2, Category);
			stat.setString(3, Category);
			stat.setString(4, Category);
			stat.setString(5, Category);
			stat.executeUpdate();
		
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
			
		
	
	}
}
