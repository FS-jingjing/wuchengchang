package factory;

import dao.CartDao;
import dao.CartDaoImpl;
import dao.FlowerDao;
import dao.FlowerDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;
import dao.OrderDetailDao;
import dao.OrderDetailDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class Factory {
	public static FlowerDao getFlowerDao(){
		FlowerDao dao=new FlowerDaoImpl();
		return dao;
	}
	public static UserDao getUserDao(){
		UserDao dao=new UserDaoImpl();
		return dao;
	}
	public static CartDao getCartDao(){
		CartDao dao=new CartDaoImpl();
		return dao;
	}
	public static OrderDao getOrderDao(){
		OrderDao dao=new OrderDaoImpl();
		return dao;
	} 
	public static OrderDetailDao getOrderDetailDao(){
		OrderDetailDao dao=new OrderDetailDaoImpl();
		return dao;
	} 
}
