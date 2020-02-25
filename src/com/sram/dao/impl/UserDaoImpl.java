package com.sram.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sram.beans.User;
import com.sram.dao.UserDao;
import com.sram.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	public User login(String username, String password) {
		try {
			Connection conn = JDBCUtil.getConnetion();
			String sql = "select * from t_user where username = ? and password = ?";   //ռλ��

			// ��ȡ���ݿ��������
			PreparedStatement ps = conn.prepareStatement(sql);  //Ԥ����sql

			//�滻��
			ps.setString(1, username);
			ps.setString(2, password);
			//ִ��sql
			ResultSet set = ps.executeQuery();
			
			while(set.next()){
				int id = set.getInt("id");
				String name = set.getString("username");
				String pass = set.getString("password");
				
				User user = new User(id, name, pass);
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
