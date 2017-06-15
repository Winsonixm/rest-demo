package com.example.dao;

import com.example.db.User;

public interface UserDao {

	void add(User user);

	//查找用户名密码是否匹配
	User find(String username, String password);

	// 查找要注册用户是否已经存在
	boolean find(String username);

}