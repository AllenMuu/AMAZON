package com.amazon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amazon.bin.User;
import com.amazon.biz.UserBiz;
import com.amazon.bizimpl.UserBizImpl;

import sun.awt.RepaintArea;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		UserBiz IUserBiz = new UserBizImpl();
		String param = req.getParameter("param");
		if (param.equals("register")) {
			String username = req.getParameter("userName");
			String passWord = req.getParameter("passWord");
			String sex = req.getParameter("sex");
			String birthday = req.getParameter("birthday");
			String identity = req.getParameter("identity");
			String email = req.getParameter("email");
			String mobile = req.getParameter("mobile");
			String address = req.getParameter("address");
			User user = new User(username, passWord, sex, birthday, identity, email, mobile, address);
			// 调用业务层方法
			boolean flag = IUserBiz.registerUser(user);
			if (flag) {
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			} else {
				resp.sendRedirect(req.getContextPath() + "/register.jsp");
			}
		} else if (param.equals("queryByName")) {
			
		} else if (param.equals("queryByEmail")) {

		} else if (param.equals("queryBylike")) {

		} else if (param.equals("exit")) {
			// 修改用户状态为0
			User u = (User) req.getSession().getAttribute("user");

			int status = IUserBiz.Logout(u);

			if (status>0) {
				HttpSession session = req.getSession(false);// 防止创建Session
				if (session == null) {
					resp.sendRedirect(req.getContextPath() + "/index.jsp");
					return;
				}
				session.removeAttribute("user");
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			}

		}

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
