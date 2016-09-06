package com.gss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gss.dao.CartManage;
import com.gss.dao.impl.CartManageImpl;
import com.gss.entity.Cart;

public class CartService extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		
		if(action.equals("showallcartgoods"))
			showallcartgoods(request,response);
		else if(action.equals("addoneprodect"))
			addOneProdect(request,response);
			
			
		
	}
	
	private void showallcartgoods(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userid = "02016083101";  //´ýÐÞ¸Ä
		
		CartManage cm = new CartManageImpl();
		Cart cart = cm.showAllCart(userid);
		
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("").forward(request, response);
		
		
	}
	
	private void addOneProdect(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String goodid = request.getParameter("goodid");
		
		
	}

}
