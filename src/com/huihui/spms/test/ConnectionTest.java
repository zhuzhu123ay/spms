package com.huihui.spms.test;

import java.sql.Connection;

import com.huihui.spms.jdbc.ConnectionFactory;

/**
 * 测试是否可以连接成功
 * */
public class ConnectionTest {
	public static void main(String[] args) {
		try {
			Connection conn=ConnectionFactory.getConn();
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
