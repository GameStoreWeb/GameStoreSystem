package com.gss.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	private static String url = "jdbc:mysql://localhost:3306/e-commerce";
	private static String user = "root";
	private static String password = "123456";
	

	public static Connection getConn(){
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			// �������ݿ�
			
			System.out.println("���ݿ����ӿ�ʼ");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("���ݿ����ӳɹ�");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeDB(Connection conn, Statement stat, ResultSet rs){
			try {
				if(rs != null)
					rs.close();
				if(stat != null)
					stat.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
