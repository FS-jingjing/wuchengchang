package dao;

import java.util.List;

import beans.OrderDetail;

public interface OrderDetailDao {
	int addOrderDetail(OrderDetail od);
	List<OrderDetail> query(String orderCode);
	int deleteAllByCode(String OrderCode);
}
