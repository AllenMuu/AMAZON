package com.amazon.dao;

import java.sql.SQLException;
import java.util.List;
import com.amazon.bin.User;

public interface UserDao {
	public int save(User user) throws SQLException;
	public List<User> query() throws SQLException;
	public User query(User user) throws SQLException; 
	public int updatelogin(User user)throws SQLException;
	public int updateregister(User user)throws SQLException;
	public int getStatus(User user)throws SQLException;
}
