package com.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import beans.Cart;

public class CheckOrderServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try{
			Map<String,Cart>map=(Map<String, Cart>) session.getAttribute("cart");
			Set<String>keys=map.keySet();
			for(String k:keys){
				Cart car=map.get(k);
				int x=car.getCount();
			}
		}catch(NullPointerException npe){
			JOptionPane.showMessageDialog(null, "你的购物车中没有商品！");
			response.sendRedirect("shopCart.jsp");
			return;
		}
		response.sendRedirect("order.jsp");
	}
}
