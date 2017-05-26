package dao;

import java.util.List;

import beans.Order;

public interface OrderDao {
	List<Order> queryAll();
	List<Order> queryAll(String userName);
	List<Order> queryAll(int page,int pageSize);
	Order queryById(int orderid);
	int addOrder(Order o);
	int queryCountByUser(String userName);
	int deleteByCode(String OrderCode);
	int getPageSum(int pageSize);
}
