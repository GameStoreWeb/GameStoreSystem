package com.gss.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gss.dao.OrderManage;
import com.gss.dao.WarehouseManage;
import com.gss.dao.impl.OrderManageImpl;
import com.gss.dao.impl.WarehouseManageImpl;
import com.gss.entity.GoodVo;
import com.gss.entity.Goods;
import com.gss.entity.OrderVo;
import com.gss.entity.Seller;
import com.gss.entity.UserOrder;

public class WarehouseService extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WarehouseService() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		doPost(request, response);
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
		
		if("showSellerProducts".equals(action)){
			showSellerProducts(request, response);
		}else if ("addProducts".equals(action)) {
			addProducts(request, response);
		}else if ("showSellerOrders".equals(action)) {
			showSellerOrders(request, response);
		}else if ("showUnitOrder".equals(action)) {
			showUnitOrder(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	public void showSellerProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Seller seller = (Seller)session.getAttribute("seller");
		List<Goods> goods = new ArrayList<Goods>();
		WarehouseManage wm = new WarehouseManageImpl();
		goods = wm.showSellerProducts(seller.getsId());
//		request.setAttribute("goods", goods);
		session.setAttribute("goods", goods);
		request.getRequestDispatcher("./seller_products.jsp").forward(request, response);
	}
	
	public void addProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Seller seller = (Seller)session.getAttribute("seller");
		
		String productName = request.getParameter("productName");
		String productType = request.getParameter("productType");
		String productDetail = request.getParameter("productDetail");
		String productStandard = request.getParameter("productStandard");
		String productPrice = request.getParameter("productPrice");
		String productDiscount = request.getParameter("productDiscount");
		
		List<String> productPicture = new ArrayList<String>();
		productPicture.add("/GameStoreSystem/images/2K/NBA2K17/big2.jpg");
		productPicture.add("/GameStoreSystem/images/2K/NBA2K17/big2.jpg");
		productPicture.add("/GameStoreSystem/images/2K/NBA2K17/big2.jpg");
		productPicture.add("/GameStoreSystem/images/2K/NBA2K17/big2.jpg");
		productPicture.add("/GameStoreSystem/images/2K/NBA2K17/big2.jpg");
		
		Goods good = new Goods(0, productName, productType, productDetail, Float.parseFloat(productDiscount), productStandard, Double.parseDouble(productPrice), null, productPicture, 0, null);
		
		WarehouseManage wm = new WarehouseManageImpl();
		wm.addGoods(good, seller.getsId());
		
		session.setAttribute("good", good);
		request.getRequestDispatcher("./WarehouseService?action=showSellerProducts").forward(request, response);
	}
	
	public void showSellerOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Seller seller = (Seller)session.getAttribute("seller");
		List<UserOrder> sellerOrders = new ArrayList<UserOrder>();
		
		WarehouseManage wm = new WarehouseManageImpl();
		sellerOrders = wm.showAllOrder(seller.getsId());
//		System.out.println(sellerOrders);
//		session.setAttribute("sellerOrders", sellerOrders);
		request.setAttribute("sellerOrders", sellerOrders);
		request.getRequestDispatcher("./sellerOrder.jsp").forward(request, response);
	}
	
	public void showUnitOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		UserOrder order = new UserOrder();
		OrderManage om = new OrderManageImpl();
		String oid = request.getParameter("oid");
		order = om.showUnitOrder(oid);
		
		OrderVo orderVo = null;
		List<GoodVo> list = new ArrayList<GoodVo>();
		for(int i=0; i<order.getGoodsItem().size(); i++){
			GoodVo goodVo = new GoodVo(order.getGoodsItem().get(i), order.getGoodsQuantity().get(i));
			list.add(goodVo);
		}
		orderVo = new OrderVo(order.getoId(), order.getsId(), order.getoAddress(), order.getStartDate(), order.isoIsTake(), order.getoTotal(), order.getoDeliverDate(), order.isoIsDeliver(), list);
		session.setAttribute("order", orderVo);
//		System.out.println(order);
//		request.setAttribute("order", order);
		
		request.getRequestDispatcher("./sellerOrderDetail.jsp").forward(request, response);
		
	}

}
