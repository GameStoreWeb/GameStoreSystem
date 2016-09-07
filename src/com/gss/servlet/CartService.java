package com.gss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gss.dao.CartManage;
import com.gss.dao.impl.CartManageImpl;
import com.gss.entity.Cart;
import com.gss.entity.CartDetails;
import com.gss.entity.User;

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
		else if(action.equals("suboneprodect"))
			suboneprodect(request,response);
		else if(action.equals("deleteoneprodect"))
			deleteoneprodect(request,response);
		else if(action.equals("addoneprodect"))
			addoneprodect(request,response);	
			
		
	}
	
	private void showallcartgoods(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		String userid = user.getuId();  //´ýÐÞ¸Ä
		
		CartManage cm = new CartManageImpl();
		Cart cart = cm.showAllCart(userid);
		float total = cm.getTotalPrice(cart);
		
		request.setAttribute("cart", cart);
		request.setAttribute("total", total);
		request.getRequestDispatcher("./cart.jsp").forward(request, response);
		
		
	}
	
	private void addOneProdect(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getuId();  //´ýÐÞ¸Ä
		String goodid = request.getParameter("goodid");
		CartManage cm = new CartManageImpl();
		cm.modifyGoods_in(Integer.valueOf(goodid), userid);
		request.getRequestDispatcher("./CartService?action=showallcartgoods").forward(request, response);
	}

	private void suboneprodect(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getuId();  //´ýÐÞ¸Ä
		String goodid = request.getParameter("goodid");
		CartManage cm = new CartManageImpl();
		CartDetails details = cm.getCartDetailsById(userid, Integer.valueOf(goodid));
		if(details.getQuantity()>1){
			details.setQuantity(details.getQuantity()-1);
			cm.updateCartDetails(details);
			request.getRequestDispatcher("./CartService?action=showallcartgoods").forward(request, response);
		}else{
			request.setAttribute("goodid", goodid);
			request.getRequestDispatcher("./CartService?action=deleteoneprodect").forward(request, response);
		}
		
	}
	
	private void deleteoneprodect(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getuId();  //´ýÐÞ¸Ä
		String goodid = request.getParameter("goodid");
		CartManage cm = new CartManageImpl();
		cm.deleteGoods(Integer.valueOf(goodid), userid);
		request.getRequestDispatcher("./CartService?action=showallcartgoods").forward(request, response);
	}
	
	private void addoneprodect(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getuId();  //´ýÐÞ¸Ä
		String goodid = request.getParameter("goodid");
		CartManage cm = new CartManageImpl();
		cm.addGoods(Integer.valueOf(goodid), userid,1);
		request.getRequestDispatcher("./CartService?action=showallcartgoods").forward(request, response);
	}
}
