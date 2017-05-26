package com.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;
import beans.Flower;
import beans.User;
import dao.CartDao;
import dao.FlowerDao;
import factory.Factory;

public class UpdateShopCartServlet extends HttpServlet{
	HttpSession session = null;
	private FlowerDao daof = Factory.getFlowerDao();
	private CartDao daoc = Factory.getCartDao();
	private String userName;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		User u=(User)session.getAttribute("login");
		userName=u.getUserName();
		String scount=request.getParameter("count");
		String sflowerId=request.getParameter("flowerId");
		String type=request.getParameter("type");
		if(type!=null&&type.equals("kong")){
			session.removeAttribute("cart");
			int x=daoc.deleteAll(userName);
			response.sendRedirect("ShopCartServlet?type=0");
		}else if(type!=null&&type.equals("delete")){
			int flowerId=Integer.parseInt(sflowerId);
			daoc.deleteOne(userName, flowerId);
			response.sendRedirect("ShopCartServlet?type=0");
		}
		if(scount!=null&&sflowerId!=null){
			int count =Integer.parseInt(scount);
			int flowerId = Integer.parseInt(sflowerId);
			int x=daoc.updateCount(userName, flowerId, count);
			response.sendRedirect("ShopCartServlet?type=0");
		}
		
	}
}
