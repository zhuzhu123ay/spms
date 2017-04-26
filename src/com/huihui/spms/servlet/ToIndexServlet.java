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
 * 跳转到后腰首页，将工作信息传递到前端页面
 */
@WebServlet("/toIndex")
public class ToIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		request.setCharacterEncoding("UTF-8");
		//2.调用service层的方法查询所有的工作信息
		IProductService productService=new ProductServiceImpl();
		try {
			
			//查询出所有的产品信息
			List<Product> list=productService.listAll();
			//将产品信息保存到request中
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//3.跳转到首页
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
