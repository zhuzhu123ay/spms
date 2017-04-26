package com.huihui.spms.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.huihui.spms.bean.Staff;
import com.huihui.spms.service.IStaffService;
import com.huihui.spms.service.impl.StaffServiceImpl;

/**
 * 显示职工人员信息
 */
@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.设置编码
				request.setCharacterEncoding("UTF-8");
				//2.调用service层的方法查询所有的员工信息
				IStaffService staffService=new StaffServiceImpl();
				try {
					
					//查询出所有的员工信息
					List<Staff> list=staffService.listAll();
					
					//Staff staff=new Staff(1L, "1", "123", "45", 12);
					//将产品信息保存到request中
					//List list1=new ArrayList();
					//list1.add(staff);
					request.setAttribute("list", list);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//3.跳转到首页
				request.getRequestDispatcher("/WEB-INF/jsp/staff.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
