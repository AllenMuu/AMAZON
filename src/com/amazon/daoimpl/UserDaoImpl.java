package com.amazon.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.amazon.bin.User;
import com.amazon.dao.UserDao;
import com.amazon.utils.C3P0Util;


public class UserDaoImpl implements UserDao{

	@Override
	public int save(User user) throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "insert into HWUA_USER values(null,?,md5(?),?,?,?,?,?,?,0)";
		Object[] params = { user.getUserName(), user.getPassword(), user.getSex(),user.getBirthday(),user.getIdentity(),user.getEmail(),user.getMobile(),user.getAddress()};
		QueryRunner qr = new QueryRunner();
		return qr.update(conn, sql, params);
	}
	/*
	 * (查询所有,sql语句需要修改)
	 * @see com.amazon.dao.UserDao#query()
	 */
	@Override
	public List<User> query() throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "select id,name,pwd,email from HWUA_USER";
		Object[] params = null;
		QueryRunner qr = new QueryRunner();
		List<User> users = qr.query(conn, sql, new BeanListHandler<>(User.class), params);
		return users;
	}

	@Override
	public User query(User user) throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "select HU_USER_ID as userId,HU_USER_NAME as userName,HU_PASSWORD as password from HWUA_USER where HU_USER_NAME = ? and HU_PASSWORD = ?";
		Object[] params = { user.getUserName(), user.getPassword() };
		QueryRunner qr = new QueryRunner();
		user = qr.query(conn, sql, new BeanHandler<>(User.class), params);
		return user;
	}
	@Override
	public int updatelogin(User user) throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "update HWUA_USER set HU_STATUS= 1 where HU_USER_NAME= ?";
		Object[] params = { user.getUserName() };
		QueryRunner qr = new QueryRunner();
		// 加入QueryRunner对象，给定一个数据源参数，那么连接当执行完后会自动释放（返回连接池）
		return qr.update(conn, sql, params);
	}
	@Override
	public int updateregister(User user) throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "update HWUA_USER set HU_STATUS= 0 where HU_USER_NAME= ?";
		Object[] params = { user.getUserName() };
		QueryRunner qr = new QueryRunner();
		return qr.update(conn, sql, params);
	}
	@Override
	public int getStatus(User user) throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "select HU_STATUS from HWUA_USER where HU_USER_NAME=?";
		Object[] params = { user.getUserName() };
		QueryRunner qr = new QueryRunner();
		int status =(Integer) qr.query(conn, sql, new ScalarHandler(), params);
		return status;
	}

}
