package com.gss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gss.dao.CartManage;
import com.gss.dao.WarehouseManage;
import com.gss.dao.impl.CartManageImpl;
import com.gss.dao.impl.WarehouseManageImpl;
import com.gss.entity.Goods;

public class GoodsService extends HttpServlet {

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
		if (action.equals("showAllGoods"))
				showAllGoods(request,response);
		else if (action.equals("addGoods"))
			addGoods(request, response);
		else if (action.equals("showUnitGoods"))
			showUnitGoods(request, response);
		
		
		
	}
	
	public void showAllGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Goods> goods = new ArrayList<Goods>();
		WarehouseManage wm = new WarehouseManageImpl();
		goods = wm.showAllGoods();
		request.setAttribute("allgoods", goods);
		request.getRequestDispatcher("./products_all.jsp").forward(request, response);
	}
	
	public void addGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid = "02016083101";  //´ýÐÞ¸Ä
		String goodid = request.getParameter("goodid");
		CartManage cm = new CartManageImpl();
		
		if(cm.isInCart(userid, Integer.valueOf(goodid)))
			cm.modifyGoods_in(Integer.valueOf(goodid), userid);
		else 
			cm.addGoods(Integer.valueOf(goodid), userid,1);
		
		request.getRequestDispatcher("./products_all.jsp").forward(request, response);
			
	}
	public void showUnitGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String goodid = request.getParameter("goodid");
		WarehouseManage wm = new WarehouseManageImpl();
		Goods good = wm.findGoodsById(Integer.valueOf(goodid));
		
		request.setAttribute("goods", good);
		request.getRequestDispatcher("./products_single.jsp").forward(request, response);	
	}

}
