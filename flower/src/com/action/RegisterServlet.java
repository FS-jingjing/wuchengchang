package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		UserDao dao=new UserDaoImpl();
		User user=new User();
		String id=request.getParameter("id"); 
		if(id!=null){
			if(dao.queryOneByName(id)){
				pw.print("用户名重复！");
			}
		}else{
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String pwd1=request.getParameter("pwd1");
			String type=request.getParameter("type");
			user.setUserName(name);
			user.setEmail(email);
			user.setPassword(pwd1);
			int x=dao.register(user);
			if(x>0){
				if(type!=null){
					
				}else{
					response.sendRedirect("login.jsp");
				}
				
			}else{
				response.sendRedirect("register.jsp");
			}
		}
		
	}
}
