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
			String sql = "select * from t_user where username = ? and password = ?";   //占位符

			// 获取数据库操作对象
			PreparedStatement ps = conn.prepareStatement(sql);  //预加载sql

			//替换？
			ps.setString(1, username);
			ps.setString(2, password);
			//执行sql
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
