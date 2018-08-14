package com.amazon.bizimpl;

import java.sql.SQLException;
import java.util.List;

import com.amazon.bin.User;
import com.amazon.biz.UserBiz;
import com.amazon.dao.UserDao;
import com.amazon.daoimpl.UserDaoImpl;
import com.amazon.utils.C3P0Util;

public class UserBizImpl implements UserBiz {
	private UserDao IUserDao = null;

	public UserBizImpl() {
		IUserDao = new UserDaoImpl();
	}

	@Override
	public User login(User user) {
		User u = new User();
		
		try {
			int status = IUserDao.getStatus(user);
			if (status == 0) {
				u = IUserDao.query(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public boolean registerUser(User user) {
		int res = 0;
		try {
			C3P0Util.startTransaction();
			res = IUserDao.save(user);
			C3P0Util.commit();
		} catch (SQLException e) {
			try {
				C3P0Util.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("注册失败");
		}
		return res == 0 ? false : true;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> uList = null;
		try {
			uList = IUserDao.query();
		} catch (SQLException e) {
			throw new RuntimeException("查询用户失败");
		}
		return uList;
	}

	@Override
	public int Logout(User user) {
		int status = 0;
		try {
			status = IUserDao.updatelogin(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
