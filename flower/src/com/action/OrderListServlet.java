package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Flower;
import beans.Order;
import dao.OrderDao;
import factory.Factory;

public class OrderListServlet extends HttpServlet{
	private OrderDao daoo=Factory.getOrderDao();
	private final int PAGESIZE=10;
	private int page=0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String str=request.getParameter("type");
		if(str==null){
			page=1;
		}else if(str.equals("xia")){
			page+=1;
		}else if(str.equals("shang")){
			page-=1;
		}
		List<Order>list=daoo.queryAll(page, PAGESIZE);
		int pageSum=daoo.getPageSum(PAGESIZE);
		session.setAttribute("Opage", page);
		session.setAttribute("pageSum", pageSum);		
		session.setAttribute("orderList", list);
		response.sendRedirect("Admin/orderList.jsp");
	}
}
