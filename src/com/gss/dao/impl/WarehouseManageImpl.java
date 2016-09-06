package com.gss.dao.impl;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gss.commons.JdbcUtils;
import com.gss.commons.Utils;
import com.gss.dao.AccountManage;
import com.gss.dao.OrderManage;
import com.gss.dao.WarehouseManage;
import com.gss.entity.Goods;
import com.gss.entity.Seller;
import com.gss.entity.UserOrder;

public class WarehouseManageImpl implements WarehouseManage {


	@Override
	public void addGoods(Goods goods, int sellerid) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		ResultSet rs = null;
		String Categoryid = findIDByCategoryname(goods.getgCategory());
		if(" ".equals(Categoryid)) 
		{
			newCategory(goods.getgCategory());
			Categoryid = findIDByCategoryname(goods.getgCategory());
		}
		
		try {
			String sql = "INSERT INTO product (productName,typeNo,detail,standard,price,producerNo,discount,sales) VALUES (?,?,?,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, goods.getgName());
			stat.setString(2, Categoryid);
			stat.setString(3, goods.getgDetail());
			stat.setString(4, goods.getgStandard());
			stat.setDouble(5, goods.getgPrice());
			stat.setInt(6, sellerid);
			stat.setFloat(7, goods.getgDiscount());
			stat.setInt(8, 0);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		int productNo = 0;
		String sql1 = "select max(productNo) as id from product";
		try {
			stat = conn.prepareStatement(sql1);
			rs = stat.executeQuery();
			
			while (rs.next()) {
				productNo = rs.getInt("id");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(productNo);
		
		String sql2 = "insert into productimg(productNo, smallImg, bigImg, bigImg1, bigImg2, bigImg3) values(?, ?, ?, ?, ?, ?)";
		try {
			stat = conn.prepareStatement(sql2);
			stat.setInt(1, productNo);
			stat.setString(2, goods.getgPicture().get(0));
			stat.setString(3, goods.getgPicture().get(1));
			stat.setString(4, goods.getgPicture().get(2));
			stat.setString(5, goods.getgPicture().get(3));
			stat.setString(6, goods.getgPicture().get(4));
			
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
		
	}

	@Override
	public void deleteGoods(Goods goods, int sellerid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = JdbcUtils.getConn();
		String sql = "delete from product where productNo = ? and producerNo = ?";
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, goods.getgId());
			statement.setInt(2, sellerid);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, null);
		}
	}

	@Override
	public void modifyGoods(Goods goods, int sellerid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stat = null;
		conn = JdbcUtils.getConn();
		
		String Categoryid = findIDByCategoryname(goods.getgCategory());
		if(" ".equals(Categoryid)) 
		{
			newCategory(goods.getgCategory());
			Categoryid = findIDByCategoryname(goods.getgCategory());
		}
		
		try {
			String sql = "update product set productName=?, detail=?, standard=?, price=?, discount=?, sales=? where productNo = ? and producerNo = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, goods.getgName());
			stat.setString(2, goods.getgDetail());
			stat.setString(3, goods.getgStandard());
			stat.setDouble(4, goods.getgPrice());
			stat.setFloat(5, goods.getgDiscount());
			stat.setInt(6, 0);
			stat.setInt(6, goods.getgId());
			stat.setInt(7, sellerid);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtils.closeDB(conn, stat, null);
		}
	}

	@Override
	public void deliverGoods(String id, int sellerid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = JdbcUtils.getConn();
		
		String sql = "update order set hasSend = ?, sendDate = ? where orderNo = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setBoolean(1, true);
			statement.setDate(2, new Date(new java.util.Date().getTime()));
			statement.setString(3, id);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, null);
		}
	}

	
	public void newCategory(String Category) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		conn = JdbcUtils.getConn();
		
		String protypeNo = null;
		
		String sql2 = "select protypeNo from protype";
		
		try {
			stat = conn.prepareStatement(sql2);
			rs = stat.executeQuery();
			
			//生成类别ID
			int max = 0;
			while (rs.next()) {
				if(Integer.parseInt(rs.getString("protypeNo")) > max)
					max = Integer.parseInt(rs.getString("protypeNo"));
			}
			protypeNo = ""+(max+1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String sql = "INSERT INTO protype VALUES(?, ?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, protypeNo);
			stat.setString(2, Category);
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
		Goods goods = new Goods();
		
		try {
			String sql = "SELECT * FROM product WHERE productNo = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, goodsid);
			rs = stat.executeQuery();	
			while(rs.next())
			{
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
				List<String> images = showAllGoodsImage(goodsid);
				goods.setgPicture(images);			
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
	
	
	
	public String findCategoryById(String id)
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
	

	


	@Override
	public void cancelOrder(String id, int sellerid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = JdbcUtils.getConn();
		
		//更新订单内容，设置isDeliver=false，isTake=true表示订单已取消
		String sql = "update order set hasSend = 0, hasReceive = 1 where orderNo = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, null);
		}
	}

	@Override
	public List<UserOrder> showAllOrder(int id) {
		
		List<UserOrder> userorders= new ArrayList<UserOrder>();
		OrderManage om = new OrderManageImpl();
		userorders = om.showAllOrders(""+id);
		return userorders;
	}
	
	/**
	 * 根据种类名称查找id号
	 * @param Category
	 * @return -1 ：没有找到  其他：找到
	 */
	public String findIDByCategoryname(String Category) {
		String id = " ";
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
				id = rs.getString("protypeNo");
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
	

	@Override
	public List<Goods> findGoodsByKw(String keyword) {
		// TODO Auto-generated method stub
		List<Goods> goods = new ArrayList<Goods>();
		List<Integer> list = new ArrayList<Integer>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();
		//按关键字搜索订单
		String sql = "select productNo from product where productName like ? or typeNo like ? or detail like ? or producerNo like ?";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, "%" + keyword + "%");
			statement.setString(2, "%" + keyword + "%");
			statement.setString(3, "%" + keyword + "%");
			statement.setString(4, "%" + keyword + "%");
			rs = statement.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getInt("productNo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeDB(connection, statement, rs);
		}
		
		WarehouseManage wm = new WarehouseManageImpl();
		for (Integer id : list) {
			Goods good = wm.findGoodsById(id);
			goods.add(good);
		}
		return goods;
	}

	@Override
	public List<Goods> showAllGoods() {
		List<Goods> goods = new ArrayList<Goods>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();


		
	    String sql = "select * from product";
		try {
					statement = connection.prepareStatement(sql);
					rs = statement.executeQuery();
					
					while (rs.next()) {
						Goods good = new Goods();
						int productno = rs.getInt("productNo");
						good.setgId(productno);
						good.setgName(rs.getString("productName"));
						good.setgCategory(rs.getString("typeNo"));
						good.setgDetail(rs.getString("detail"));
						good.setgStandard(rs.getString("standard"));
						good.setgPrice(rs.getDouble("price"));
						AccountManage am = new SellerLoginManageImpl();
						good.setgSeller((Seller)am.showUnitInfo(""+rs.getInt("producerNo")));
						good.setgDiscount(rs.getFloat("discount"));
						good.setgSalesvolume(rs.getInt("sales"));;
						
						List<String> images = showAllGoodsImage(productno);
						good.setgPicture(images);						
						goods.add(good);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		return goods;
	}

	@Override
	public List<String> showAllGoodsImage(int goodid) {
		List<String> images = new ArrayList<String>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();

	    String sql = "select * from productimg WHERE productNo = ? ";
		try {
					statement = connection.prepareStatement(sql);
					statement.setInt(1, goodid);
					rs = statement.executeQuery();
					
					
					while (rs.next()) {
						images.add(rs.getString("smallImg"));
						images.add(rs.getString("bigImg"));
						images.add(rs.getString("bigImg1"));
						images.add(rs.getString("bigImg2"));
						images.add(rs.getString("bigImg3"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
					
		
		return images;
	}

	@Override
	public List<Goods> showSellerProducts(int sellerId) {
		// TODO Auto-generated method stub
		List<Goods> goods = new ArrayList<Goods>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = JdbcUtils.getConn();

	    String sql = "select * from product where producerNo = ?";
		try {
					statement = connection.prepareStatement(sql);
					statement.setInt(1, sellerId);
					rs = statement.executeQuery();
					
					while (rs.next()) {
						Goods good = new Goods();
						int productno = rs.getInt("productNo");
						good.setgId(productno);
						good.setgName(rs.getString("productName"));
						good.setgCategory(rs.getString("typeNo"));
						good.setgDetail(rs.getString("detail"));
						good.setgStandard(rs.getString("standard"));
						good.setgPrice(rs.getDouble("price"));
						AccountManage am = new SellerLoginManageImpl();
						good.setgSeller((Seller)am.showUnitInfo(""+rs.getInt("producerNo")));
						good.setgDiscount(rs.getFloat("discount"));
						good.setgSalesvolume(rs.getInt("sales"));;
						
						List<String> images = showAllGoodsImage(productno);
						good.setgPicture(images);						
						goods.add(good);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		return goods;
	}
	
}
