package com.sram.dao;

import com.sram.beans.User;

public interface UserDao {
	public abstract User login(String username,String password);
}
