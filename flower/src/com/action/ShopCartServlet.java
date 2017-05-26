package com.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

@SuppressWarnings("serial")
public class ShopCartServlet extends HttpServlet {
	HttpSession session = null;
	private FlowerDao daof = Factory.getFlowerDao();
	private CartDao daoc = Factory.getCartDao();
	private String userName;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		User user = (User) session.getAttribute("login");
		if (user == null) {
			response.sendRedirect("login.jsp");
		} else {
			userName = user.getUserName();
			String type = request.getParameter("type");
			if (type != null) {
				session.setAttribute("cart", daoc.queryMap(userName));
				response.sendRedirect("shopCart.jsp");
			} else {
				int flowerId = Integer.parseInt(request.getParameter("flowerId"));
				userName = user.getUserName();
				if (daoc.queryOne(userName, flowerId)) {
					daoc.updateCount(userName, flowerId);
					session.setAttribute("cart", daoc.queryMap(userName));
					response.sendRedirect("shopCart.jsp");
				} else {
					Flower fl = daof.queryOneByFlowerId(flowerId);
					Cart car = new Cart();
					car.setUserName(user.getUserName());
					car.setFlowerId(Integer.parseInt(fl.getFlowerId()));
					car.setCount(1);
					int x = daoc.addCart(car);
					if (x > 0) {
						session.setAttribute("cart", daoc.queryMap(userName));
						response.sendRedirect("shopCart.jsp");
					} else {
						response.sendRedirect("index.jsp");
					}
				}
			}
		}

	}
}
