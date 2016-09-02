package com.gss.dao.impl;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gss.commons.JdbcUtils;
import com.gss.dao.AccountManage;
import com.gss.dao.OrderManage;
import com.gss.dao.WarehouseManage;
import com.gss.entity.Goods;
import com.gss.entity.Seller;
import com.gss.entity.SellerOrder;
import com.gss.entity.UserOrder;

public class WarehouseManageImpl implements WarehouseManage {


	@Override
	public void addGoods(Goods goods, String sellerid) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		String Categoryid = goods.getgCategory();
		
		try {
			String sql = "INSERT INTO product(productName,typeNo,detail,standard,price,producerNo,discount,sales) VALUES(?,?,?,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, goods.getgName());
			stat.setString(2, Categoryid);
			stat.setString(3, goods.getgDetail());
			stat.setString(4, goods.getgStandard());
			stat.setDouble(5, goods.getgPrice());			
			stat.setInt(6, goods.getgSeller().getsId());
			stat.setFloat(7, goods.getgDiscount());
			stat.setInt(8, 0);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}

	}

	@Override
	public void deleteGoods(int goodsid) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
			
		try {
			String sql = "DELETE FROM product WHERE productNo = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, goodsid);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
		
	}



	@Override
	public void modifyGoods(Goods goods, int sales) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		String Categoryid = goods.getgCategory();
		
		try {
			String sql = "UPDATE product SET productName = ,typeNo = ?,detail = ?,standard = ?,price = ?,producerNo = ?,discount = ?,sales = ? WHERE productNo = ? ";
			stat = conn.prepareStatement(sql);
			stat.setString(1, goods.getgName());
			stat.setString(2, Categoryid);
			stat.setString(3, goods.getgDetail());
			stat.setString(4, goods.getgStandard());
			stat.setDouble(5, goods.getgPrice());			
			stat.setInt(6, goods.getgSeller().getsId());
			stat.setFloat(7, goods.getgDiscount());
			stat.setInt(8,sales);
			stat.setInt(9,goods.getgId());
			
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
		
	}



	@Override
	public void deliverGoods(int orderid) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		
		try {
			String sql = "UPDATE order SET hasSend = ? WHERE orderid = ? ";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, 1);
			stat.setInt(2, orderid);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
		
	}

	@Override
	public void cancelOrder(int id, int sellerid) {
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		
		try {
			String sql = "UPDATE order SET hasSend = ? AND hasReceive =? WHERE orderid = ? ";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, 0);
			stat.setInt(2, 1);
			stat.setInt(3, sellerid);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}

	}

	@Override
	public List<UserOrder> showAllOrder(String id) {
		List<UserOrder> sellerorder = new ArrayList<UserOrder>();
		
		OrderManage om = new OrderManageImpl();
		sellerorder = om.showAllOrders(id);
		return sellerorder;
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
				goods.setgCategory(rs.getString("typeNo"));
				goods.setgDetail(rs.getString("detail"));
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
	
	
//	public String findCategoryById(int id)
//	{
//		String  name= null;
//		Connection conn = null;
//		PreparedStatement stat = null;
//		conn = JdbcUtils.getConn();
//		ResultSet rs = null;
//		
//		try {
//			String sql = "SELECT protypeName FROM protype WHERE protypeNo = ?";
//			stat = conn.prepareStatement(sql);
//			stat.setInt(1, id);
//			rs = stat.executeQuery();
//			while(rs.next())
//			{
//				id = rs.getInt(1);
//			}
//		}catch (Exception e)
//		{
//			e.printStackTrace();
//		}finally
//		{
//			JdbcUtils.closeDB(conn, stat, rs);
//		}
//			
//		
//		return name;
//		
//	}


	public int findSellerByOrderId(int id)
	{
		String  name= null;
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		ResultSet rs = null;
		int productid = -1;
		int sellerid = -1;
		try {
			String sql = "SELECT productNo FROM orderdetails WHERE id = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			while(rs.next())
			{
				productid = rs.getInt(1);
			}
			
			String sql1 = "SELECT producerNo FROM product WHERE productNo = ?";
			stat = conn.prepareStatement(sql1);
			stat.setInt(1, productid);
			rs = stat.executeQuery();
			while(rs.next())
			{
				sellerid = rs.getInt(1);
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, rs);
		}
			
		
		return sellerid;
		
	}



}
