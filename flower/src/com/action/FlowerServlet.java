package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Flower;
import dao.FlowerDao;
import factory.Factory;

public class FlowerServlet extends HttpServlet{
	private final int PAGESIZE=10;
	private FlowerDao daof=Factory.getFlowerDao();
	private int page=0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		String id=request.getParameter("id");
		if(id!=null){
			Flower fl=daof.queryOneByFlowerIsbn(id);
			if(fl==null){
				pw.print("");
			}else{
				pw.print("编号重复！");
			}
		}else{
			String str=request.getParameter("type");
			if(str==null){
				page=1;
			}else if(str.equals("xia")){
				page+=1;
			}else if(str.equals("shang")){
				page-=1;
			}
			String p=request.getParameter("page");
			if(p!=null){
				page=Integer.parseInt(p);
			}
			List<Flower>list=daof.queryAllByPage(page, PAGESIZE);
			int pageSum=daof.queryPage(PAGESIZE);
			session.setAttribute("page", page);
			session.setAttribute("pageSum", pageSum);
			session.setAttribute("flowerList", list);
			response.sendRedirect("Admin/flowerList.jsp");
		}
	}
}
