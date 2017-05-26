package com.action;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;
import beans.Order;
import beans.OrderDetail;
/*private int id;
private String orderCode;
private int flowerId;
private String flowerNumber;
private double flowerPrice;
private double subtotal;
private int typeId;*/
import beans.User;
import dao.CartDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import factory.Factory;

public class OrderDetailsServlet extends HttpServlet{
	private static int x;
	private OrderDao daoo=Factory.getOrderDao();
	private OrderDetailDao daod=Factory.getOrderDetailDao();
	private CartDao daoc=Factory.getCartDao();
	static{
		x=100;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("login");
		Map<String,Cart>map=(Map<String, Cart>) session.getAttribute("cart");
		Order o=(Order) session.getAttribute("orders");

		try{
			Order order =new Order();
			String code=getOrderCode();
			double total=getTotal(map);
			order.setOrderCode(code);
			order.setUserName(user.getUserName());
			order.setMobilPhone(o.getMobilPhone());
			order.setEmail(user.getEmail());
			order.setProvince(o.getProvince());
			order.setCity(o.getCity());
			order.setAddress(o.getAddress());
			order.setTotal(total);
			order.setOrderTime(new Date(System.currentTimeMillis()));
			order.setOrderStatus(0);
			int x=daoo.addOrder(order);
			if(x>0){
				List<OrderDetail> list=getOrderDetail(map, code);
				int sum=0;
				for(OrderDetail od:list){
					int num=daod.addOrderDetail(od);
					sum+=num;
				}
				if(sum==list.size()){
					daoc.deleteAll(order.getUserName());
					session.removeAttribute("cart");
					response.sendRedirect("MyOrderServlet");
				}
			}
		}catch(NullPointerException npe){
			response.sendRedirect("login.jsp");
		}
		
	}
	
	private String getOrderCode(){
		java.util.Date date1=new java.util.Date(System.currentTimeMillis());
		Date date=new Date(System.currentTimeMillis());
		char[] chs=date.toString().toCharArray();
		int h=date1.getHours();
		int m=date1.getMinutes();
		int s=date1.getSeconds();
		String str="";
		for(int i=0;i<chs.length;i++){
			if(Character.isDigit(chs[i])){
				str+=chs[i];
			}
		}
		if(h/10<1){
			str+="0"+h;
		}
		str+=h;
		if(m/10<1){
			str+="0"+m;
		}
		str+=m;
		if(s/10<1){
			str+="0"+s;
		}
		str+=s;
		str+=x;
		if(x==999){
			x=100;
		}
		return str;
	}
	
	private List<OrderDetail> getOrderDetail(Map<String,Cart> map,String code){
		List<OrderDetail> list=new ArrayList<OrderDetail>();
		Set<String>keys=map.keySet();
		for(String s:keys){
			Cart car=map.get(s);
			OrderDetail od=new OrderDetail();
			od.setOrderCode(code);
			od.setFlowerId(car.getFlowerId());
			od.setFlowerNumber(car.getCount());
			od.setFlowerPrice(car.getCurrentPrice());
			od.setSubTotal(car.getCurrentPrice()*car.getCount());
			od.setTypeId(car.getTypeId());
			list.add(od);
		}
		return list;
	}
	private double getTotal(Map<String,Cart> map){
		Set<String>keys=map.keySet();
		double d=0;
		for(String s:keys){
			Cart car=map.get(s);
			d+=car.getCurrentPrice()*car.getCount();
		}
		return d;
	}
}
