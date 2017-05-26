package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Flower;
import dao.FlowerDao;
import factory.Factory;

@SuppressWarnings("serial")
public class FlowerListServlet extends HttpServlet{
	private final int PAGESIZE=10;
	private int page;
	private int pageSum;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlowerDao dao=Factory.getFlowerDao();
		HttpSession session=request.getSession();
		int type=Integer.parseInt(request.getParameter("type"));
		String types=request.getParameter("types");
		if(types==null){
			page=0;
		}else if(types.equals("shang")){
			page=page-1;
		}else if(types.equals("xia")){
			page=page+1;
		}
		List<Flower> list=dao.queryFlowerAll(type,PAGESIZE,page);
		pageSum=dao.queryFlowerPageSum(type, PAGESIZE);
		session.setAttribute("pageSum", pageSum);
		session.setAttribute("page", page+1);
		session.setAttribute("flowerList", list);
		if(type==0){
			response.sendRedirect("flower.jsp");
		}else if(type==1){
			response.sendRedirect("cake.jsp");
		}else if(type==2){
			response.sendRedirect("gift.jsp");
		}else if(type==3){
			response.sendRedirect("lvZhiHuaHui.jsp");
		}else if(type==4){
			response.sendRedirect("shangWu.jsp");
		}
	}
}
