package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserListServlet extends HttpServlet{
	private final int PAGESIZE=5;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserDao dao=new UserDaoImpl();
		String page=request.getParameter("Upage");
		int Upage=1;
		if(page!=null){
			Upage=Integer.parseInt(page);
		}
		List<User>list=dao.queryAll(Upage, PAGESIZE);
		int pageSum=dao.pageSum(PAGESIZE);
		HttpSession session=request.getSession();
		session.setAttribute("userList", list);
		session.setAttribute("Upage", Upage);
		session.setAttribute("pageSum", pageSum);
		response.sendRedirect("Admin/userList.jsp");
	}
	
}
