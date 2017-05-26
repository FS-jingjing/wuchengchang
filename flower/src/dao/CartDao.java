package dao;

import java.util.List;
import java.util.Map;

import beans.Cart;

public interface CartDao {
	int addCart(Cart car);
	List<Cart> queryAll(String userName);
	Map<String, Cart> queryMap(String userName);
	boolean queryOne(String userName,int flowerId);
	int updateCount(String userName,int flowerId,int num);
	boolean updateCount(String userName,int flowerId);
	int deleteAll(String userName);
	int lineCount(String userName);
	int deleteOne(String userName,int flowerId);
}
