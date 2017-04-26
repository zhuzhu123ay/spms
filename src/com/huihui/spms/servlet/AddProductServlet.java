package com.huihui.spms.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huihui.spms.bean.Product;
import com.huihui.spms.bean.Staff;
import com.huihui.spms.service.IProductService;
import com.huihui.spms.service.impl.ProductServiceImpl;

/**
 * 添加产品信息
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		request.setCharacterEncoding("UTF-8");
		//2.获取参数
		String productName=request.getParameter("productName");
		String productDate=request.getParameter("productDate");
		//String price=request.getParameter("productPrice");
		/*Double productPrice = null;
		if(price!=""&&price.length()>0){
			productPrice=Double.parseDouble(price);
		}*/
		
		/*Double productPrice = null ;
		if(price != null && !price.trim().equals("")){
		  try{
			   productPrice =Double.parseDouble(price.trim());//trim方法的作用是去掉字符串前后的空格

		   }catch(Exception e){
			   productPrice = null;
		      System.out.println("数字转换异常，信息：" + e.getMessage());
		    }
		  }*/
		

		Double productPrice=Double.parseDouble(request.getParameter("productPrice"));
		String productUse=request.getParameter("productUse");
		Product product=new Product(null,productDate,productName,productPrice,productUse);
		//3.调用service层
		IProductService productService=new ProductServiceImpl();
		try {
			productService.add(product);
			request.setAttribute("msg", "插入成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Error"+e.getMessage());
		}
		//4.跳转
		request.getRequestDispatcher("/toIndex").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
