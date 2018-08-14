package com.amazon.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	// 创建一个管理连接池的对象，它会自动读取classes目录下的名字叫c3p0-config.xml的配置文件
	// 根据配置的参数会自动创建一个连接池，并管理连接池。
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();

	public static ComboPooledDataSource getCpds() {
		return cpds;
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = cpds.getConnection();// 从连接池中获取一个连接对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 获取当前线程上所绑定的连接对象
	 * 
	 * @return
	 */
	public static Connection getCurrConnection() {
		Connection conn = tl.get();// 获取当前线程所绑定的Connection对象
		if(conn==null){
			conn=getConnection();//从连接池中获取一个连接对象
			tl.set(conn);//把connection绑定到当前的线程上
		}
		return conn;
	}
	
	/**
	 * 开始事务
	 * @throws SQLException
	 */
	public static void startTransaction() throws SQLException {
		Connection conn = getCurrConnection();//获取当前线程上绑定的连接对象
		conn.setAutoCommit(false);//手动开启线程
	}
	
	/**
	 * 提交事务
	 * @throws SQLException
	 */
	public static void commit() throws SQLException{
		Connection conn = getCurrConnection();//获取当前线程上绑定的连接对象
		conn.commit();//提交事务
		conn.close();
		tl.remove();//从线程上移除Connection对象
	}
	
	/**
	 * 回滚事务
	 * @throws SQLException
	 */
	public static void rollback() throws SQLException{
		Connection conn = getCurrConnection();//获取当前线程上绑定的连接对象
		conn.rollback();
	}

	/**
	 * 释放连接对象到连接池中
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
