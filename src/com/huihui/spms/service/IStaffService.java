package com.huihui.spms.service;

import java.util.List;

import com.huihui.spms.bean.Product;
import com.huihui.spms.bean.Staff;

/**
 * 职工相关接口，业务逻辑相关
 * */
public interface IStaffService {
	//注册职工信息
	void register(Staff staff) throws Exception;
	//职工登录
	Staff login(String username,String password) throws Exception;
	//职工离休
	void leave(long id) throws Exception;
	//显示职工信息
	List<Staff> listAll() throws Exception;
	//更新职工
	void update(Staff staff) throws Exception;
	//通过id获取姓名
	Staff getById(long id) throws Exception;
}
