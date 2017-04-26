package com.huihui.spms.test;


import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.huihui.spms.bean.Product;
import com.huihui.spms.bean.Staff;
import com.huihui.spms.dao.ProductDao;
import com.huihui.spms.dao.StaffDao;

public class DaoTest {
	StaffDao staffDao=new StaffDao();
	ProductDao productDao=new ProductDao();
	Staff staff=new Staff();
	Product product=new Product();
	
	@Test
	public void testA() {
		
		Staff staff=new Staff(null,"张三","123123","男",12);
		try {
			staffDao.save(staff);
			System.out.print("0000");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testB(){
//		try {
//			staffDao.deleteById(4);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	@Test
	public void testC(){
//		try {
//			List<Staff> list = staffDao.findAll();
//			for (Staff staff : list) {
//				System.out.println(staff.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	@Test
	public void testD(){
//		try {
//			Staff staff=staffDao.findByName("张三");
//				System.out.println(staff);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	} 
	
	@Test
	public void testE(){
		
		//Product product = new Product(null,null,"苹果",6000.0,"很贵哒好伐");
		try {
			ProductDao productDao=new ProductDao();
		//	productDao.save(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
