package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserDao dao=new UserDaoImpl();
		User user=new User();
		String name=request.getParameter("name");
		user.setUserName(name);
		String pwd=request.getParameter("pwd");
		user.setPassword(pwd);
		int status=Integer.parseInt(request.getParameter("status"));
		user.setStatus(status);
		User u=dao.login(user);
		if(u!=null){
			if(status==1){
				request.getSession().setAttribute("login", u);
				request.getSession().setAttribute("admin", u);
				response.sendRedirect("Admin/frmate.jsp");
			}else{
				request.getSession().setAttribute("login", u);
				response.sendRedirect("list");
			}
			
		}else{
			if(status==1){
				response.sendRedirect("Admin/adminLogin.jsp");
			}else{
				response.sendRedirect("login.jsp");
			}
			
		}
	}
}
