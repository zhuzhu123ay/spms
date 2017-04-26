package com.huihui.spms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huihui.spms.bean.Staff;
import com.huihui.spms.service.IProductService;
import com.huihui.spms.service.impl.ProductServiceImpl;

/**
 * 删除产品
 */
@WebServlet("/dropProduct")
public class DropProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		request.setCharacterEncoding("UTF-8");
		//2.获取参数
		long productId=Long.parseLong(request.getParameter("productId"));
		//3.调用service层方法，通过id删除选中数据
		IProductService productService=new ProductServiceImpl();
		String url="/toIndex";//默认跳转到首页
		try {
			HttpSession session=request.getSession();
			Staff staff=(Staff) session.getAttribute("staff");
			//判断是否登录
			if(staff!=null){
				productService.dropById(productId);
				request.setAttribute("msg", "删除成功");
			}else{
				url="/login.jsp";
				request.setAttribute("msg", "权限不足，请先登录");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Error"+e.getMessage());
		}
		//4.页面跳转
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
