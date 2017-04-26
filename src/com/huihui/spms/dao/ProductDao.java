package com.huihui.spms.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.huihui.spms.bean.Product;
import com.huihui.spms.jdbc.ConnectionFactory;

/**
 * 对产品信息的增删改查
 * */
public class ProductDao {

	//更新
	public void update(Product product) throws Exception{
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			try {
				//1.获取连接
				conn=ConnectionFactory.getConn();
				//2.预处理
				String sql="update tbl_product set"+" productDate = ?, productName = ?, productPrice = ?, productUse = ? where productId=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, product.getProductDate());
				pstmt.setString(2, product.getProductName());
				pstmt.setDouble(3, product.getProductPrice());
				pstmt.setString(4, product.getProductUse());
				pstmt.setLong(5, product.getProductId());
				//3.执行sql
				int num=pstmt.executeUpdate();
				System.out.println("成功更新"+num+"条");
				
			} finally {
				//4.关闭
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	//保存产品信息
	public void save(Product product) throws Exception{
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			try {
				//1.获取连接
				conn=ConnectionFactory.getConn();
				//2.预处理sql
				String sql="insert into tbl_product values(null,?,?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,product.getProductDate());
				pstmt.setString(2, product.getProductName());
				pstmt.setDouble(3, product.getProductPrice());
				pstmt.setString(4, product.getProductUse());
				//3.执行sql
				int num=pstmt.executeUpdate();
				System.out.println("成功插入"+num+"条产品信息");
			} finally {
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	
	//通过名字查询产品信息
	public List<Product> findByName(String name) throws Exception{
		List<Product> list=new ArrayList<>();
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				//1.获取连接
				conn=ConnectionFactory.getConn();
				//2.预处理
				String sql="select * from tbl_product where productName like '%"+name+"%'";
				//String sql="select * from tbl_product where productName = ?";
				pstmt=conn.prepareStatement(sql);
				//pstmt.setString(1, name);
				//3.返回结果集
				rs=pstmt.executeQuery();
				while(rs.next()){
					long productId=rs.getLong("productId");
					String productDate=rs.getString("productDate");
					String productName=rs.getString("productName");
					Double productPrice=rs.getDouble("productPrice");
					String productUse=rs.getString("productUse");
					Product product=new Product(productId,productDate,productName,productPrice,productUse);
					list.add(product);
				}
			} finally {
				//释放资源
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	//查询所有产品信息
	public List<Product> query(Long productId,String productDate,String productName,Double productPrice,String productUse) throws Exception{
		List<Product> list=new ArrayList<>();
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				//1.获取连接
				conn=ConnectionFactory.getConn();
				//2.预处理
				String sql="select * from tbl_product where 1=1";
				if(productId!=null){
					sql+=" and productId = "+productId;
				}
				if(productDate!=null){
					sql+=" and productDate = "+productDate;
				}
				if(productName!=null){
					sql+=" and productName = '"+productName+"'";
				}
				if(productPrice!=null){
					sql+=" and productPrice = "+productPrice;
				}
				if(productUse!=null){
					sql+=" and productUse ="+productUse;
				}
				pstmt=conn.prepareStatement(sql);
				//3.执行sql
				rs=pstmt.executeQuery();
				//4.处理结果集
				while(rs.next()){
					long db_productId=rs.getLong("productId");
					String db_productDate=rs.getString("productDate");
					String db_productName=rs.getString("productName");
					Double db_productPrice=rs.getDouble("productPrice");
					String db_productUse=rs.getString("productUse");
					Product product=new Product(db_productId,db_productDate,db_productName,db_productPrice,db_productUse);
					list.add(product);
				}
			} finally {
				//5.释放资源
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	//查询所有课程信息
	public List<Product> findAll() throws Exception{
		List<Product> list=new ArrayList<>();
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				//1.获取连接
				conn=ConnectionFactory.getConn();
				//2.预处理sql
				String sql="select * from tbl_product";
				pstmt=conn.prepareStatement(sql);
				//3.执行sql
				rs=pstmt.executeQuery();
				//4.处理结果集
				while(rs.next()){
					long productId=rs.getLong("productId");
					String productDate=rs.getString("productDate");
					String productName=rs.getString("productName");
					Double productPrice=rs.getDouble("productPrice");
					String productUse=rs.getString("productUse");
					//封装到product对象中，然后将product对象添加到list
					Product product=new Product(productId,productDate,productName,productPrice,productUse);
					list.add(product);				}
			} finally {
				//5.释放资源
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	//通过id删除
	public void deleteById(long productId) throws Exception{
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			try {
				//1.注册驱动+获取连接
				conn=ConnectionFactory.getConn();
				//2.预处理
				String sql="delete from tbl_product where productId = ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, productId);
				//3.执行sql
				int num=pstmt.executeUpdate();
				System.out.println("成功删除"+num+"条");
				
			} finally {
				//4.释放资源
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
