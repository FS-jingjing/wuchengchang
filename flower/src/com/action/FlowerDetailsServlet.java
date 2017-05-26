package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Flower;
import dao.FlowerDao;
import factory.Factory;

@SuppressWarnings("serial")
public class FlowerDetailsServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlowerDao dao=Factory.getFlowerDao();
		HttpSession session=request.getSession();
		int flowerId=Integer.parseInt(request.getParameter("flowerId"));
		String type=request.getParameter("type");
		Flower f=dao.queryOneByFlowerId(flowerId);
		session.setAttribute("flower", f);
		if(type!=null&&type.equals("update")){
			response.sendRedirect("Admin/addFlower.jsp");
		}else{
			response.sendRedirect("details.jsp");
		}
	}
}
