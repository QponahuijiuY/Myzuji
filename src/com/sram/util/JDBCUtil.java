package com.sram.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接数据库的工具类 
 *
 *	1.加载驱动（项目启动时加载，而且只加载一次）
	2.创建连接 Connection
	3.创建数据库操作对象
	4.执行SQL语句
	5.关闭连接
 */
public class JDBCUtil {
	private static String url = "jdbc:mysql://localhost:3306/myzuji?characterEncoding=utf8";
	private static String username = "root";
	private static String password = "Mysqlmima123";


	//静态代码块
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");//反射
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设计一个方法，用来获取驱动加载好的连接
	 * @throws SQLException 
	 */
	public static Connection getConnetion() throws SQLException{
		Connection conn =  DriverManager.getConnection(url, username, password);
		return conn;
	}

}
