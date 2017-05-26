package com.action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import beans.Flower;
import dao.FlowerDao;
import factory.Factory;

public class AddFlowerServlet extends HttpServlet{
	private FlowerDao daof=Factory.getFlowerDao();
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		SmartUpload smart=new SmartUpload();
		try {
	        smart.initialize(this.getServletConfig(), request, response);
	        smart.upload();
	        String flowerImage=smart.getFiles().getFile(0).getFileName();
	        //System.out.println(request.getSession().getServletContext().getRealPath("image"));
	        String path=request.getSession().getServletContext().getRealPath("image");
	        //String path2="upload";
	        //System.out.println(path);
	        String path1="F:\\Web\\flower\\WebContent\\image";
	        smart.save(path);
	        //smart.save(path2);
	        smart.save(path1);
			String flowerIsbn=smart.getRequest().getParameter("flowerIsbn");
			String flowerName=smart.getRequest().getParameter("flowerName");
			String flowerMaterial=smart.getRequest().getParameter("flowerMaterial");
			String flowerPack=smart.getRequest().getParameter("flowerPack");
			String type=smart.getRequest().getParameter("type");
			String yiyi=smart.getRequest().getParameter("yiyi");
			String price=smart.getRequest().getParameter("price");
			String currentPrice=smart.getRequest().getParameter("currentPrice");
			String deliverArea=smart.getRequest().getParameter("deliverArea");
			String flowerDesc=smart.getRequest().getParameter("flowerDesc");
			//System.out.println(flowerIsbn);System.out.println(flowerName);System.out.println(flowerMaterial);System.out.println(flowerPack);System.out.println(type);System.out.println(yiyi);System.out.println(price);System.out.println(currentPrice);System.out.println(flowerImage);System.out.println(deliverArea);System.out.println(flowerDesc);
			Flower fl=new Flower();
			fl.setFlowerIsbn(flowerIsbn);
			fl.setFlowerName(flowerName);
			fl.setFlowerMaterial(flowerMaterial);
			fl.setFlowerPack(flowerPack);
			fl.setDeliverArea(deliverArea);
			fl.setFlowerDesc(flowerDesc);
			fl.setCurrentPrice(Double.parseDouble(currentPrice));
			fl.setPrice(Double.parseDouble(price));
			fl.setFlowerImage(flowerImage);
			fl.setTypeId(type);
			fl.setFlowerType(yiyi);
			fl.setStatus(0+"");
			fl.setNoteTime(new Date(System.currentTimeMillis()));
			//System.out.println(fl.toString());
			int x=daof.addFlower(fl);
			//System.out.println(x);
			response.sendRedirect("FlowerServlet");
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}
}
