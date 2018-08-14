package com.amazon.biz;

import java.util.List;

import com.amazon.bin.User;

public interface UserBiz {
	public User login(User user);// 登陆
	public boolean registerUser(User user);// 注册
	public List<User> findAllUsers();
	public int Logout(User u);
}
