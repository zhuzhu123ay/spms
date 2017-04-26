package com.huihui.spms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huihui.spms.bean.Staff;

/**
 * 跳转到添加产品页面
 */
@WebServlet("/toAddProduct")
public class ToAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Staff staff=(Staff)session.getAttribute("staff");
		String url="/WEB-INF/jsp/addProduct.jsp";
		if(staff==null){
			//用户没有登录,没有添加的权限
			url="/login.jsp";
			request.setAttribute("msg", "权限不足，请先登录");
		}
		request.getRequestDispatcher(url).forward(request, response);;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
