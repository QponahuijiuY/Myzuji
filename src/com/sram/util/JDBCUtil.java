package com.sram.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �������ݿ�Ĺ����� 
 *
 *	1.������������Ŀ����ʱ���أ�����ֻ����һ�Σ�
	2.�������� Connection
	3.�������ݿ��������
	4.ִ��SQL���
	5.�ر�����
 */
public class JDBCUtil {
	private static String url = "jdbc:mysql://localhost:3306/myzuji?characterEncoding=utf8";
	private static String username = "root";
	private static String password = "Mysqlmima123";


	//��̬�����
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");//����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���һ��������������ȡ�������غõ�����
	 * @throws SQLException 
	 */
	public static Connection getConnetion() throws SQLException{
		Connection conn =  DriverManager.getConnection(url, username, password);
		return conn;
	}

}
