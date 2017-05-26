package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Order;
import beans.User;

public class OrderServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("login");
		String phone=request.getParameter("phone");
		String p=request.getParameter("p");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		Order order=new Order();
		order.setUserName(user.getUserName());
		order.setMobilPhone(phone);
		order.setEmail(user.getEmail());
		order.setProvince(p);
		order.setCity(city);
		order.setAddress(address);
		session.setAttribute("orders", order);
		response.sendRedirect("orderDetails.jsp");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
}
