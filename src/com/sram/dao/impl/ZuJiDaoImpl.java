package com.sram.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sram.beans.ZuJi;
import com.sram.dao.ZuJiDao;
import com.sram.util.JDBCUtil;

public class ZuJiDaoImpl implements ZuJiDao{

	public List<ZuJi> getZuJis() {
		List<ZuJi> zujis = new ArrayList<ZuJi>();
		try {
			Connection conn = JDBCUtil.getConnetion();
			//准备sql语句
			//排序关键字  order by         asc 升序             desc  降序
			String sql = "select * from t_zuji order by date desc";   //占位符
			// 获取数据库操作对象
			PreparedStatement ps = conn.prepareStatement(sql);  //预加载sql
			//执行sql
			ResultSet set = ps.executeQuery();
			while(set.next()){
				int id = set.getInt("id");
				String title = set.getString("title");
				String jianjie = set.getString("jianjie");
				Date date = set.getDate("date");
				String url = set.getString("url");
				ZuJi zuJi = new ZuJi(id, title, jianjie, date, url);
				zujis.add(zuJi);
			}
			return zujis;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addZuJi(ZuJi zuJi) {
		try {
			Connection conn = JDBCUtil.getConnetion();
			//准备sql语句
			//排序关键字  order by         asc 升序             desc  降序
			String sql = "insert into t_zuji values (null,?,?,?,?)";   //占位符
			// 获取数据库操作对象
			PreparedStatement ps = conn.prepareStatement(sql);  //预加载sql
			//执行sql
			
			ps.setString(1, zuJi.getTitle());
			ps.setString(2, zuJi.getJianjie());
			ps.setDate(3, new java.sql.Date(zuJi.getDate().getTime()));
			ps.setString(4, zuJi.getUrl());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteZuJi(int id) {
		try {
			Connection conn = JDBCUtil.getConnetion();
			//准备sql语句
			//排序关键字  order by         asc 升序             desc  降序
			String sql = "delete from t_zuji where id = ?";   //占位符
			// 获取数据库操作对象
			PreparedStatement ps = conn.prepareStatement(sql);  //预加载sql
			//执行sql
			ps.setInt(1, id);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public ZuJi getZuJi(int id) {
		try {
			Connection conn = JDBCUtil.getConnetion();
			//准备sql语句
			//排序关键字  order by         asc 升序             desc  降序
			String sql = "select * from t_zuji where id = ?";   //占位符
			// 获取数据库操作对象
			PreparedStatement ps = conn.prepareStatement(sql);  //预加载sql
			//执行sql
			ps.setInt(1, id);
			
			ResultSet set = ps.executeQuery();
			while(set.next()){
				String title = set.getString("title");
				String jianjie = set.getString("jianjie");
				Date date = set.getDate("date");
				String url = set.getString("url");
				ZuJi zuJi = new ZuJi(id, title, jianjie, date, url);
				return zuJi;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateZuJi(ZuJi zuJi) {
		try {
			Connection conn = JDBCUtil.getConnetion();
			//准备sql语句
			//排序关键字  order by         asc 升序             desc  降序
			String sql = "update t_zuji set title = ?,jianjie = ?,date = ?,url = ? where id = ?";   //占位符
			// 获取数据库操作对象
			PreparedStatement ps = conn.prepareStatement(sql);  //预加载sql
			//执行sql
			
			ps.setString(1, zuJi.getTitle());
			ps.setString(2, zuJi.getJianjie());
			ps.setDate(3, new java.sql.Date(zuJi.getDate().getTime()));
			ps.setString(4, zuJi.getUrl());
			ps.setInt(5, zuJi.getId());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
