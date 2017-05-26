package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.FlowerDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.UserDao;
import factory.Factory;

public class DeleteServlet extends HttpServlet{
	private OrderDao daoo=Factory.getOrderDao();
	private OrderDetailDao daod=Factory.getOrderDetailDao();
	private FlowerDao daof=Factory.getFlowerDao();
	private UserDao daou=Factory.getUserDao();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type=request.getParameter("type");
		String[] str = request.getParameterValues("checkbox");
		if(type.equals("flower")){
			if(str==null){
				response.sendRedirect("FlowerServlet");
			}else{
				for(String s:str){
					daof.deleteOneById(Integer.parseInt(s));
				}
				response.sendRedirect("FlowerServlet");
			}
			
		}else if(type.equals("user")){
			if(str==null){
				response.sendRedirect("UserListServlet");
			}else{
				for(String s:str){
					daou.deleteById(Integer.parseInt(s));
				}
				response.sendRedirect("UserListServlet");
			}
		}else if(type.equals("order")){
			if(str==null){
				response.sendRedirect("OrderListServlet");	
			}else{
				for(String s:str){
					String code=daoo.queryById(Integer.parseInt(s)).getOrderCode();
					daod.deleteAllByCode(code);
					daoo.deleteByCode(code);
				}
				response.sendRedirect("OrderListServlet");
			}
		}
	}
}
