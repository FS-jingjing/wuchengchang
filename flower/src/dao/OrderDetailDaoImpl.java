package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Flower;
import beans.Order;
import beans.OrderDetail;
import db.DButil;
import factory.Factory;

public class OrderDetailDaoImpl implements OrderDetailDao {
	
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private FlowerDao daof=Factory.getFlowerDao(); 
	
	/* id  number(11) NOT NULL primary key,
   orderCode  varchar2(50) NOT NULL,
   flowerID  number(11) NOT NULL,
   flowerNumber  number(11) NOT NULL,
   flowerPrice  number(7,2) NOT NULL,
   subtotal  number(7,2) NOT NULL,
   typeId  number(11) NOT NULL*/
	@Override
	public int addOrderDetail(OrderDetail od) {
		con=DButil.getCon();
		String sql="insert into orderdetail values(seq_orderdetail.nextval,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, od.getOrderCode());
			ps.setInt(2, od.getFlowerId());
			ps.setInt(3, od.getFlowerNumber());
			ps.setDouble(4, od.getFlowerPrice());
			ps.setDouble(5, od.getSubTotal());
			ps.setInt(6, Integer.parseInt(od.getTypeId()));
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
	public List<OrderDetail> query(String orderCode) {
		List<OrderDetail> list=new ArrayList<OrderDetail>();
		con=DButil.getCon();
		String sql="select * from orderdetail where ordercode=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, orderCode);
			rs=ps.executeQuery();
			while(rs.next()){
				OrderDetail od=getOrderDetail(rs);
				list.add(od);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return null;
	}
	
	public OrderDetail getOrderDetail(ResultSet rs) throws SQLException{
		int flowerId=rs.getInt(3);
		Flower fl=daof.queryOneByFlowerId(flowerId);
		OrderDetail od=new OrderDetail();
		od.setId(rs.getInt(1));
		od.setOrderCode(rs.getString(2));
		od.setFlowerId(flowerId);
		od.setFlowerName(fl.getFlowerName());
		od.setFlowerNumber(rs.getInt(4));
		od.setFlowerPrice(rs.getDouble(5));
		od.setPrice(fl.getPrice());
		od.setSubTotal(rs.getDouble(6));
		od.setTypeId(rs.getInt(7)+"");
		od.setType(fl.getFlowerType());
		return od;
	}
	
	@Override
	public int deleteAllByCode(String OrderCode) {
		List<Integer>list=new ArrayList<Integer>();
		con=DButil.getCon();
		String sql="select id from orderDetail where ordercode=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, OrderCode);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(rs.getInt(1));
			}
			int x=0;
			for(int i:list){
				String sqld="delete from orderDetail where id=?";
				ps=con.prepareStatement(sqld);
				ps.setInt(1, i);
				x+=ps.executeUpdate();
			}
			if(x==list.size()){
				return x;
			}
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return 0;
	}
}








