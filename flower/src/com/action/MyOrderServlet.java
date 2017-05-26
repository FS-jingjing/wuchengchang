package com.action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Order;
import beans.OrderDetail;
import beans.User;
import dao.CartDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import factory.Factory;

public class MyOrderServlet extends HttpServlet{
	
	private OrderDao daoo=Factory.getOrderDao();
	private OrderDetailDao daod=Factory.getOrderDetailDao();
	private CartDao daoc=Factory.getCartDao();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String type=request.getParameter("type");
		if(type!=null&&type.equals("find")){
			String orderCode=request.getParameter("orderCode");
			List<OrderDetail> list=daod.query(orderCode);
			session.setAttribute("orderDetailList", list);
			response.sendRedirect("orderFlowerDetailList.jsp");
		}else if(type==null||type==""){
			try{
				User user=(User)session.getAttribute("login");
				List<Order> list=daoo.queryAll(user.getUserName());
				int count = daoo.queryCountByUser(user.getUserName());
				Date date=new Date(System.currentTimeMillis());
				session.setAttribute("date", date);
				session.setAttribute("count", count);
				session.setAttribute("myorder", list);
				response.sendRedirect("myOrder.jsp");
			}catch(NullPointerException npe){
				response.sendRedirect("login.jsp");
			}
		}
	}
}
