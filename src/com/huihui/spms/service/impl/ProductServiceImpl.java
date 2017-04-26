package com.huihui.spms.service.impl;

import java.util.List;

import com.huihui.spms.bean.Product;
import com.huihui.spms.dao.ProductDao;
import com.huihui.spms.service.IProductService;

/**
 * 产品相关的业务逻辑接口
 * */
public class ProductServiceImpl implements IProductService{
	private ProductDao productDao=new ProductDao();
	@Override
	public void add(Product product) throws Exception {
		productDao.save(product);
	}
	@Override
	public List<Product> query(String productDate, String productName, Double productPrice, String productUse)
			throws Exception {
		return productDao.query(null, productDate, productName, productPrice, productUse);
	}
	@Override
	public List<Product> listAll() throws Exception {
		return productDao.findAll();
	}
	@Override
	public void dropById(long productId) throws Exception {
		productDao.deleteById(productId);
	}
	@Override
	public void update(Product product) throws Exception {
		productDao.update(product);
	}
	@Override
	public Product getById(long productId) throws Exception {
		List<Product> list=productDao.query(productId, null, null, null, null);
		if(list.size()>0){
			return list.get(0);
			}
		return (Product) list;
	}
	@Override
	public List<Product> getByName(String productName) throws Exception {
		
		return productDao.findByName(productName);
	}
}
