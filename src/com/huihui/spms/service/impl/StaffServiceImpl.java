package com.huihui.spms.service.impl;

import java.util.List;

import com.huihui.spms.bean.Product;
import com.huihui.spms.bean.Staff;
import com.huihui.spms.dao.StaffDao;
import com.huihui.spms.service.IStaffService;

public class StaffServiceImpl implements IStaffService{

	private StaffDao staffDao=new StaffDao();
	/**
	 *注册（不允许用户名重名） 
	 *1.先判断参数中的用户名是否已经被占用
	 *2.如果被占用，抛出异常，如果没占用，保存成功
	 * */
	@Override
	public void register(Staff staff) throws Exception {
		//根据参数中的username去数据库中查找，如果db_staff不为空，该用户名被占用
		Staff db_staff=staffDao.findByName(staff.getUsername());
		if(db_staff==null){
			//直接将用户名信息保存到数据库中
			staffDao.save(staff);
		}else{
			//占用
			throw new Exception("该用户名已经被占用");
		}
	}

	/**
	 * 登录
	 * 1.通过username找用户的信息staff
	 * 2.password==staff.getPassword();
	 * 如果正确登录成功，否则失败
	 * 3.将staff返回
	 * */
	@Override
	public Staff login(String username, String password) throws Exception {
		Staff staff=null;
		Staff db_staff=staffDao.findByName(username);
		if(db_staff!=null){
			//判断用户输入的密码与数据库中的密码是否匹配
			if(password.equals(db_staff.getPassword())){
				staff=db_staff;
			}else{
				throw new Exception("密码错误！");
			}
		}else{
			throw new Exception("用户名不存在！");
		}
		return staff;
	}

	@Override
	public void leave(long id) throws Exception {
		staffDao.deleteById(id);
	}

	@Override
	public List<Staff> listAll() throws Exception {
		return staffDao.findAll();
	}

	@Override
	public void update(Staff staff) throws Exception {
		staffDao.update(staff);
	}

	@Override
	public Staff getById(long id) throws Exception {
		List<Staff> list=staffDao.query(id, null, null, null, null);
		if(list.size()>0){
			return list.get(0);
			}
		return (Staff) list;
		
	}

}
