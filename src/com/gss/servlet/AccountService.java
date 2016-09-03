package com.gss.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gss.dao.AccountManage;
import com.gss.dao.impl.UserLoginManageImpl;
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

		if ("login".equals(action)) {
			login(request, response);
		}else if ("register".equals(action)) {
			register(request, response);
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
		// µÇÂ½³É¹¦
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

}
