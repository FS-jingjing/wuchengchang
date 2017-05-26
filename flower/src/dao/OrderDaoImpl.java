package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Flower;
import beans.Order;
import db.DButil;

public class OrderDaoImpl implements OrderDao {
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	/*orderId  number(11) NOT NULL primary key,
	   orderCode  varchar2(50) NOT NULL unique,
	   userName  varchar2(20) NOT NULL,
	   mobilphone  varchar2(24) NOT NULL,
	   email  varchar2(100) NOT NULL,
	   province  varchar2(20) NOT NULL,
	   city  varchar2(20) NOT NULL,
	   address  varchar2(512) NOT NULL,
	   total  number(7,2) NOT NULL,
	   orderTime  date NOT NULL,
	   orderStatus  number(11) NOT NULL*/
	@Override
	public int addOrder(Order o) {
		con=DButil.getCon();
		String sql="insert into orders values(seq_orders.nextval,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, o.getOrderCode());
			ps.setString(2, o.getUserName());
			ps.setString(3, o.getMobilPhone());
			ps.setString(4, o.getEmail());
			ps.setString(5, o.getProvince());
			ps.setString(6, o.getCity());
			ps.setString(7, o.getAddress());
			ps.setDouble(8, o.getTotal());
			ps.setDate(9, o.getOrderTime());
			ps.setInt(10, o.getOrderStatus());
			int x=ps.executeUpdate();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, null);
		}
		return 0;
	}
	@Override
	public List<Order> queryAll(String userName) {
		List<Order> list=new ArrayList<Order>();
		con=DButil.getCon();
		String sql="select * from orders where username=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			rs=ps.executeQuery();
			while(rs.next()){
				Order o=getOrder(rs);
				list.add(o);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return null;
	}
	
	public Order getOrder(ResultSet rs) throws SQLException{
		Order order=new Order();
		order.setOrderId(rs.getInt(1));
		order.setOrderCode(rs.getString(2));
		order.setUserName(rs.getString(3));
		order.setMobilPhone(rs.getString(4));
		order.setEmail(rs.getString(5));
		order.setProvince(rs.getString(6));
		order.setCity(rs.getString(7));
		order.setAddress(rs.getString(8));
		order.setTotal(rs.getDouble(9));
		order.setOrderTime(rs.getDate(10));
		order.setOrderStatus(rs.getInt(11));
		return order;
	}
	
	@Override
	public int queryCountByUser(String userName) {
		con=DButil.getCon();
		String sql="select count(*) from orders where username=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			rs=ps.executeQuery();
			if(rs.next()){
				int x=rs.getInt(1);
				return x;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return 0;
	}
	
	@Override
	public List<Order> queryAll() {
		List<Order> list=new ArrayList<Order>();
		con=DButil.getCon();
		String sql="select * from orders";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Order order=getOrder(rs);
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return null;
	}
	
	@Override
	public int deleteByCode(String OrderCode) {
		con=DButil.getCon();
		String sql="delete from orders where ordercode=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, OrderCode);
			int x=ps.executeUpdate();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, null);
		}
		return 0;
	}
	
	@Override
	public Order queryById(int orderid) {
		con=DButil.getCon();
		String sql="select * from orders where orderid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, orderid);
			rs=ps.executeQuery();
			if(rs.next()){
				Order order=getOrder(rs);
				return order;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return null;
	}
	
	@Override
	public int getPageSum(int pageSize) {
		con=DButil.getCon();
		String sql="select count(*) from orders";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				int count=rs.getInt(1);
				if(count%pageSize==0){
					return count/pageSize;
				}else{
					return count/pageSize+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return 0;
	}
	
	@Override
	public List<Order> queryAll(int page, int pageSize) {
		List<Order>list=new ArrayList<Order>();
		con=DButil.getCon();
		String sql="select * from (select f.*,rownum r from orders f) where r>? and r<?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (page-1)*pageSize);
			ps.setInt(2, page*pageSize+1);
			rs=ps.executeQuery();
			while(rs.next()){
				Order o=getOrder(rs);
				list.add(o);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return null;
	}
	
}
















