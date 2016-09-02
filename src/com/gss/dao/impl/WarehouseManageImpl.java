package com.gss.dao.impl;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.gss.commons.JdbcUtils;
import com.gss.dao.AccountManage;
import com.gss.dao.WarehouseManage;
import com.gss.entity.Goods;
import com.gss.entity.Seller;
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
			String sql = "INSERT INTO product (productName,typeNo,describe,standard,price,producerNo,discount,sales) VALUES (?,?,?,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, goods.getgName());
			stat.setInt(2, Categoryid);
			stat.setString(3, goods.getgDetail());
			stat.setString(4, goods.getgStandard());
			stat.setDouble(5, goods.getgPrice());
			stat.setString(6, goods.getgSeller());
			stat.setInt(7, goods.getgPicture());
			stat.setString(8, cartNo);
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
	
	
	public void newProducting(List<String> images, int productid) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		try {
			String sql = "INSERT INTO productimg (smallImg,bigImg1,bigImg2,bigImg3,bigImg,productNo) VALUES(?,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, images.get(0));
			stat.setString(2, images.get(1));
			stat.setString(3, images.get(2));
			stat.setString(4, images.get(3));
			stat.setString(5, images.get(4));
			stat.setInt(6, productid);
			stat.executeUpdate();		
					
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
			
	
	}

	@Override
	public Goods findGoodsById(int goodsid) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		ResultSet rs = null;
		Goods goods = null;
		
		try {
			String sql = "SELECT * FROM product WHERE productNo = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, goodsid);
			rs = stat.executeQuery();	
			while(rs.next())
			{
				goods = new Goods();
				goods.setgId(goodsid);
				goods.setgName(rs.getString("productName"));
				goods.setgCategory(findCategoryById(goodsid));
				goods.setgDetail(rs.getString("describe"));
				goods.setgStandard(rs.getString("standard"));
				goods.setgPrice(rs.getDouble("price"));
				AccountManage am = new SellerLoginManageImpl();
				Object object = am.showUnitInfo("" + rs.getInt("producerNo"));
				goods.setgSeller((Seller)object);
				goods.setgDiscount(rs.getFloat("discount"));
				goods.setgSalesvolume(rs.getInt("sales"));
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, rs);
		}
			
		return goods;
	}
	
	
	public String findCategoryById(int id)
	{
		String  name= null;
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		ResultSet rs = null;
		
		try {
			String sql = "SELECT protypeName FROM protype WHERE protypeNo = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			rs = stat.executeQuery();
			while(rs.next())
			{
				id = rs.getString(1);
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, rs);
		}
			
		
		return name;
		
	}
}
