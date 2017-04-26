package com.huihui.spms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huihui.spms.bean.Product;
import com.huihui.spms.service.IProductService;
import com.huihui.spms.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class QueryProductServlet
 */
@WebServlet("/queryProduct")
public class QueryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.设置编码
		request.setCharacterEncoding("UTF-8");
		// 2.获取参数
		String productName = request.getParameter("name");
		// 3.调用service层方法
		IProductService productService = new ProductServiceImpl();
		String url="";
		try {
			if(productName==""){
			url="/WEB-INF/jsp/index.jsp";
			}else{
			List<Product> list=productService.getByName(productName);
			request.setAttribute("list", list);
			request.setAttribute("msg", "查询成功");
			url="/WEB-INF/jsp/queryProduct.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Error" + e.getMessage());
		}
		// 4.跳转
			request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
