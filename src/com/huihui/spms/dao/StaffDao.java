package com.huihui.spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.huihui.spms.bean.Product;
import com.huihui.spms.bean.Staff;
import com.huihui.spms.jdbc.ConnectionFactory;

public class StaffDao {

	
	//更新
		public void update(Staff staff) throws Exception{
			try {
				Connection conn=null;
				PreparedStatement pstmt=null;
				try {
					//1.获取连接
					conn=ConnectionFactory.getConn();
					//2.预处理
					String sql="update tbl_staff set"+" username = ?, password = ?, gender = ?, age = ? where id=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, staff.getUsername());
					pstmt.setString(2, staff.getPassword());
					pstmt.setString(3, staff.getGender());
					pstmt.setInt(4, staff.getAge());
					pstmt.setLong(5, staff.getId());
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
	
	
	// 删除
	public void deleteById(long id) throws Exception {
		try {

			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 获取连接
				conn = ConnectionFactory.getConn();
				// 预处理sql
				String sql = "delete from tbl_staff where id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				// 执行
				int num = pstmt.executeUpdate();
				System.out.print("删除" + num + "条");
			} finally {
				// 释放
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// 通过姓名查询职工信息
	public Staff findByName(String name) throws Exception {
		Staff staff = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 获取连接
				conn = ConnectionFactory.getConn();
				// 预处理sql
				String sql = "select * from tbl_staff where username = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				// 处理结果集
				rs = pstmt.executeQuery();
				while (rs.next()) {
					long id = rs.getLong("id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String gender = rs.getString("gender");
					int age = rs.getInt("age");
					staff = new Staff(id, username, password, gender, age);

				}
			} finally {
				// 释放资源
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return staff;
	}
	
	//查询所有人员信息（有参数）
		public List<Staff> query(Long id,String username,String password,String gender,Integer age) throws Exception{
			List<Staff> list=new ArrayList<>();
			try {
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					//1.获取连接
					conn=ConnectionFactory.getConn();
					//2.预处理
					String sql="select * from tbl_staff where 1=1";
					if(id!=null){
						sql+=" and id = "+id;
					}
					if(username!=null){
						sql+=" and username = "+username;
					}
					if(password!=null){
						sql+=" and password = '"+password+"'";
					}
					if(gender!=null){
						sql+=" and gender = "+gender;
					}
					if(age!=null){
						sql+=" and age ="+age;
					}
					pstmt=conn.prepareStatement(sql);
					//3.执行sql
					rs=pstmt.executeQuery();
					//4.处理结果集
					while(rs.next()){
						long db_id=rs.getLong("id");
						String db_username=rs.getString("username");
						String db_password=rs.getString("password");
						String db_gender=rs.getString("gender");
						Integer db_age=rs.getInt("age");
						Staff staff=new Staff(db_id,db_username,db_password,db_gender,db_age);
						list.add(staff);
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
	
	//查询职工信息(无参数)
	public List<Staff> findAll() throws Exception{
		List<Staff> list=new ArrayList<>();
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				//获取连接
				conn=ConnectionFactory.getConn();
				//预处理
				String sql="select * from tbl_staff";
				pstmt=conn.prepareStatement(sql);
				//处理结果集
				rs=pstmt.executeQuery();
				while(rs.next()){
					long id=rs.getLong("id");
					String username=rs.getString("username");
					String password=rs.getString("password");
					String gender=rs.getString("gender");
					int age=rs.getInt("age");
					Staff staff=new Staff(id,username,password,gender,age);
					list.add(staff);
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
	//保存职工信息
	public void save(Staff staff) throws Exception{
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			try {
				//1.获取连接
				conn=ConnectionFactory.getConn();
				//2.获取pstmt对象，预处理sql，并替换占位符
				String sql="insert into tbl_staff values(null,?,?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,staff.getUsername());
				pstmt.setString(2,staff.getPassword());
				pstmt.setString(3, staff.getGender());
				pstmt.setInt(4, staff.getAge());
				//3.执行sql
				int num=pstmt.executeUpdate();
				System.out.println("成功插入"+num);
			} finally {
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
				e.printStackTrace();
				throw e;
		}
	}
}
