package com.gss.commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	 @Override
	  public void doFilter(ServletRequest servletRequest,
	      ServletResponse servletResponse, FilterChain filterChain)
	      throws IOException, ServletException {
	    // �ж��Ƿ���http����
	    if (!(servletRequest instanceof HttpServletRequest)
	        || !(servletResponse instanceof HttpServletResponse)) {
	      throw new ServletException(
	          "OncePerRequestFilter just supports HTTP requests");
	    }
	    // ��������������Ҫ�õ�request,response,session����
	    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
	    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
	    HttpSession session = httpRequest.getSession(true);

	    String[] strs = {"index"}; // ·���а�����Щ�ַ�����,���Բ��õ�¼ֱ�ӷ���
	    StringBuffer url = httpRequest.getRequestURL();
	    
	    /**
	     * ���˵���Ŀ¼
	     */
	    String path = httpRequest.getContextPath();
	    String protAndPath = httpRequest.getServerPort() == 80 ? "" : ":"
	        + httpRequest.getServerPort();
	    String basePath = httpRequest.getScheme() + "://"
	        + httpRequest.getServerName() + protAndPath + path + "/";
	    if (basePath.equalsIgnoreCase(url.toString())) {
	      filterChain.doFilter(servletRequest, servletResponse);
	      return;
	    }
	    // ������;��·������ֱ�ӷ���
	    if (strs != null && strs.length > 0) {
	      for (String str : strs) {
	        if (url.indexOf(str) >= 0) {
	          filterChain.doFilter(servletRequest, servletResponse);
	          return;
	        }
	      }
	    }
	    // ��session�л�ȡ�û���Ϣ
	    String loginInfo = (String) session.getAttribute("username");
	    if (null == loginInfo || "".equals(loginInfo)) {
	      // �û�����,���Է��ʴ˵�ַ
	      filterChain.doFilter(servletRequest, servletResponse);
	    } else {
	      // �û�������,�߻ص�¼ҳ��
	      String returnUrl = httpRequest.getContextPath() + "/account.jsp";
	      httpRequest.setCharacterEncoding("UTF-8");
	      httpResponse.setContentType("text/html; charset=UTF-8"); // ת��
	      httpResponse
	          .getWriter()
	          .println(
	              "<script language=\"javascript\">alert(\"����û�е�¼�����ȵ�¼!\");if(window.opener==null){window.top.location.href=\""
	                  + returnUrl
	                  + "\";}else{window.opener.top.location.href=\""
	                  + returnUrl
	                  + "\";window.close();}</script>");
	      return;
	    }

	  }

	  @Override
	  public void init(FilterConfig arg0) throws ServletException {

	  }

	  @Override
	  public void destroy() {

	  }

}
