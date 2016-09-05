package com.gss.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gss.dao.AccountManage;
import com.gss.dao.impl.SellerLoginManageImpl;
import com.gss.dao.impl.UserLoginManageImpl;
import com.gss.entity.Page;
import com.gss.entity.Seller;
import com.gss.entity.User;

public class AccountService extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AccountService() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String selecter = request.getParameter("selecter");
		if("seller".equals(selecter))
			action = "sellerLogin";

		if ("login".equals(action)) {
			login(request, response);
		}else if ("sellerLogin".equals(action)) {
			sellerLogin(request, response);
		}else if ("register".equals(action)) {
			register(request, response);
		}else if ("showAllSeller".equals(action)) {
			showAllSeller(request, response);
		}else if ("addSeller".equals(action)) {
			addSeller(request, response);
		}else if ("deleteSeller".equals(action)) {
			deleteSeller(request, response);
		}else if ("updateSeller".equals(action)) {
			updateSeller(request, response);
		}else if ("getSeller".equals(action)) {
			getSeller(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");

		
		AccountManage sm = new UserLoginManageImpl();
		// 登陆成功
		if (sm.checkLogin(name, pwd)) {
			response.sendRedirect("./index.jsp");
		} else {
			response.sendRedirect("./account.jsp?tag=1");
		}
	}
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex").equals("boy") ? "M" : "F";
		String telephone = request.getParameter("telephone");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User user = new User(null, password, userName, sex, name, telephone);
		
		AccountManage um = new UserLoginManageImpl();
		if(um.register((Object)user)){
			response.sendRedirect("./index.jsp");
		}else {
			response.sendRedirect("./register.jsp?tag=2");
		}
	}
	
	public void sellerLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		AccountManage sm = new SellerLoginManageImpl();
		Seller seller = (Seller)sm.showUnitInfo(id);
		// 登陆成功
		if (sm.checkLogin(id, pwd)) {
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
			session.setAttribute("seller", seller);
			response.sendRedirect("./sellerInfo.jsp");
		} else {
			response.sendRedirect("./account.jsp?tag=1");
		}
	}
	
	public void showAllSeller(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = 10;
		int pageNo = 1;
		//pageNo不为空，把他转化成整型类型
		if(!"".equals(request.getParameter("pageNo")) && null != request.getParameter("pageNo"))
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		AccountManage sm = new SellerLoginManageImpl();
		
		Page<Seller> page = sm.findSellers(pageNo, pageSize);
		//通过request对象传递值
		request.setAttribute("page", page);
		request.getRequestDispatcher("./list.jsp").forward(request, response);
	}
	
	public void addSeller(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sname = request.getParameter("sellerName");
		String spwd = request.getParameter("sellerPwd");
		String saddress = request.getParameter("address");
		String sphone = request.getParameter("telephone");
		
		Seller seller = new Seller(0, sname, saddress, sphone, spwd);
		
		AccountManage sm = new SellerLoginManageImpl();
		sm.register((Object)seller);
		
		request.getRequestDispatcher("./AccountService?action=showAllSeller").forward(request, response);
	}
	
	public void deleteSeller(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		AccountManage sm = new SellerLoginManageImpl();
		sm.deleteAccount(sid);
		
		request.getRequestDispatcher("./AccountService?action=showAllSeller").forward(request, response);
	}
	
	public void updateSeller(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("ID");
		String sname = request.getParameter("sellerName");
		String spwd = request.getParameter("sellerPwd");
		String saddress = request.getParameter("address");
		String sphone = request.getParameter("telephone");
		String method = request.getParameter("method");
		Seller seller = new Seller(Integer.parseInt(sId), sname, saddress, sphone, spwd);
		
		HttpSession session = request.getSession();
		
		AccountManage sm = new SellerLoginManageImpl();
		sm.modifyUnitInfo((Object)seller);
		
		if("local".equals(method)){
			session.setAttribute("seller", seller);
			System.out.println(seller);
			response.sendRedirect("./sellerInfo.jsp");
		}else {
			request.getRequestDispatcher("./AccountService?action=showAllSeller").forward(request, response);
		}
	}
	
	public void getSeller(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		AccountManage sm = new SellerLoginManageImpl();
		Seller seller = (Seller)sm.showUnitInfo(sid);
		
		request.setAttribute("seller", seller);
		request.getRequestDispatcher("./update.jsp").forward(request, response);
	}

}
