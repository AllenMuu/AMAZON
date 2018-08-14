package com.amazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.bin.User;
import com.amazon.biz.UserBiz;
import com.amazon.bizimpl.UserBizImpl;
import com.amazon.utils.MD5Utils;


public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		UserBiz IUserBiz = new UserBizImpl();
		String username = req.getParameter("userName");
		String pwd = req.getParameter("passWord");
	
		// 对密码进行md5加密（java代码）
		pwd = MD5Utils.md5(pwd);// 得到MD5秘钥
		String code = req.getParameter("veryCode");// 得到输入的验证码
		String sessionCode = (String) req.getSession().getAttribute("validateCode");
		// 封装成User对象
		User user = new User(username, pwd);

		if (code != null && code.equalsIgnoreCase(sessionCode)) {
			// 调用业务层的方法进行处理
			user = IUserBiz.login(user);
			// 根据业务层返回的结果选择试图进行跳转
			if (user != null) {
				// 把用户信息放到session中
				req.getSession().setAttribute("user", user);
				System.out.println(req.getAttribute("user"));
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
			} else {
				req.setAttribute("info", "登陆失败,请先注册");
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("info", "验证码出错，重新输入");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
