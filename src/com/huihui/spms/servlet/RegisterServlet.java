package com.huihui.spms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huihui.spms.bean.Staff;
import com.huihui.spms.service.IStaffService;
import com.huihui.spms.service.impl.StaffServiceImpl;

/**
 * 实现注册功能
 * 接受请求中的参数，并且完成注册功能
 * */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1");
		//1.设置编码
		request.setCharacterEncoding("UTF-8");
		//2.获取参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String re_password=request.getParameter("re_password");
		String gender=request.getParameter("gender");
		Integer age=Integer.parseInt(request.getParameter("age"));
		//3.封装参数，调用方法
		Staff staff=new Staff(null,username,password,re_password,age);
		//当密码等于重复密码的时候，再去注册
		if(password.equals(re_password)){
			//4.调用service层方法完成用户注册
			IStaffService staffService=new StaffServiceImpl();
			String url="/login.jsp";
			try {
				staffService.register(staff);
			} catch (Exception e) {
				e.printStackTrace();
				//注册失败
				url="/register.jsp";
				//将错误信息保存到request中
				request.setAttribute("msg", e.getMessage());
			}finally{
				//跳转页面
				request.getRequestDispatcher(url).forward(request, response);
				//response.sendRedirect(url);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
