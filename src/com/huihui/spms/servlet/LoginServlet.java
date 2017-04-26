package com.huihui.spms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huihui.spms.bean.Staff;
import com.huihui.spms.service.IStaffService;
import com.huihui.spms.service.impl.StaffServiceImpl;

/**
 *处理登录业务
 * */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1。设置编码
		request.setCharacterEncoding("UTF-8");
		//2.获取参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//3.调用service层
		IStaffService staffService=new StaffServiceImpl();
		//4.默认路径的跳转，登录成功后跳转到index.jsp页面
		//String url="/toIndex";
		String url="/main.jsp";
		try {
			Staff staff=staffService.login(username, password);
			//staff登录成功的信息，将用户信息保存到session中
			HttpSession session=request.getSession();
			session.setAttribute("staff", staff);
		} catch (Exception e) {
			e.printStackTrace();
			//异常发生
			//request.setAttribute("msg",e.getMessage());
			request.setAttribute("msg","您的账号或密码错误！");
			url="/login.jsp";
		}
		//5.跳转到页面
		request.getRequestDispatcher(url).forward(request, response);
		//response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
