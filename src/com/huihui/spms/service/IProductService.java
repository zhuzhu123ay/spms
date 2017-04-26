package com.huihui.spms.service;

import java.util.List;

import com.huihui.spms.bean.Product;

public interface IProductService {
	//条件查询所有课程
	List<Product> query(String productDate,String productName,Double productPrice,String productUse)throws Exception;
	//通过id获取产品
	Product getById(long productId) throws Exception;
	//通过名字获取产品
	List<Product> getByName(String productName) throws Exception;
	//显示所有的课程
	List<Product> listAll() throws Exception;
	//录入产品
		void add(Product product) throws Exception;
	//删除产品
		void dropById(long productId) throws Exception;
	//更新课程
		void update(Product product) throws Exception;

}
