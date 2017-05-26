package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Flower;
import dao.FlowerDao;
import dao.FlowerDaoImpl;
@SuppressWarnings("serial")
public class ReFlowerServlet extends HttpServlet implements java.io.Serializable{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlowerDao dao=new FlowerDaoImpl();
			List<Flower>list1=dao.queryFlowerIndex();
			List<Flower>list2=dao.queryCakeIndex();
			List<Flower>list3=dao.queryLvzhihuahuiIndex();
			HttpSession session=request.getSession();
			session.setAttribute("reFlower", list1);
			session.setAttribute("xinCake", list2);
			session.setAttribute("xinLiLan", list3);
			response.sendRedirect("IndexFlowerServlet");
	}
	
}
