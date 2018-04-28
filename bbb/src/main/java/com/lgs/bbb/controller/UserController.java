package com.lgs.bbb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgs.bbb.service.UserService;
@WebServlet("/user/*")
public class UserController extends BaseServlet{
	private UserService us=new UserService();
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		boolean result=us.LoginService(username, password);
		if(result) {
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
		}else {
			req.setAttribute("error", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ!");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
