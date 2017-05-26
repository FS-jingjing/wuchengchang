package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import beans.Cart;
import beans.Flower;
import db.DButil;
import factory.Factory;

public class CartDaoImpl implements CartDao {

	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private FlowerDao daof = Factory.getFlowerDao();
	
	
	public Cart getCart(ResultSet rs) throws SQLException{
		Cart car=new Cart();
		car.setUserName(rs.getString(1));
		car.setFlowerId(rs.getInt(2));
		car.setCount(rs.getInt(3));
		return car;
	}
	
	@Override
	public int addCart(Cart car) {
		con=DButil.getCon();
		String sql="insert into cart values(?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, car.getUserName());
			ps.setInt(2, car.getFlowerId());
			ps.setInt(3, car.getCount());
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
	public List<Cart> queryAll(String userName) {
		List<Cart>list=new ArrayList<Cart>();
		con=DButil.getCon();
		String sql="select * from cart where username=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			rs=ps.executeQuery();
			while(rs.next()){
				Cart car=getCart(rs);
				list.add(car);
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
	public boolean queryOne(String userName,int flowerId) {
		con=DButil.getCon();
		String sql="select * from cart where username=? and flowerid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setInt(2, flowerId);
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return false;
	}

	@Override
	public int updateCount(String userName,int flowerId,int num) {
		con=DButil.getCon();
		String sql="update cart set count=? where username=? and flowerid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, userName);
			ps.setInt(3, flowerId);
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
	public boolean updateCount(String userName, int flowerId) {
		con=DButil.getCon();
		int count=0;
		String sql="select count from cart where username=? and flowerid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setInt(2, flowerId);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
				String sqlU="update cart set count=? where username=? and flowerid=?";
				ps=con.prepareStatement(sqlU);
				ps.setInt(1, count+1);
				ps.setString(2, userName);
				ps.setInt(3, flowerId);
				int x=ps.executeUpdate();
				if(x>0){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return false;
	}
	
	@Override
	public int lineCount(String userName){
		con=DButil.getCon();
		String sql="select count(*) from cart where username=?";
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
	
	
//删除	
	@Override
	public int deleteAll(String userName) {
		List<Integer>list=new ArrayList<Integer>();
		int count=lineCount(userName);
		con=DButil.getCon();
		String sqlq="select flowerid from cart where username=?";
		try {
			ps=con.prepareStatement(sqlq);
			ps.setString(1, userName);
			rs=ps.executeQuery();
			int o=0;
			while(rs.next()){
				int id=rs.getInt(1);
				list.add(id);
			}
			int x=0;
			for(Integer i:list){
				String sql="delete from cart where username=? and flowerId=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setInt(2, i);
				x+=ps.executeUpdate();
			}
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return 0;
	}
	
	
	
//查询
	@Override
	public Map<String, Cart> queryMap(String userName) {
		int count=lineCount(userName);
		if(count==0){
			return null;
		}
		List<Cart> list = queryAll(userName);
		Map<String, Cart> map = new LinkedHashMap<String, Cart>();
		for (Cart c : list) {
			Cart car = new Cart();
			Flower fl = daof.queryOneByFlowerId(c.getFlowerId());
			car.setUserName(userName);
			car.setFlowerId(Integer.parseInt(fl.getFlowerId()));
			car.setFlowerIsbn(fl.getFlowerIsbn());
			car.setFlowerName(fl.getFlowerName());
			car.setPrice(fl.getPrice());
			car.setCurrentPrice(fl.getCurrentPrice());
			car.setCount(c.getCount());
			car.setTypeId(fl.getTypeId());
			map.put(c.getFlowerId() + "", car);
		}
		return map;
	}

	@Override
	public int deleteOne(String userName, int flowerId) {
		con=DButil.getCon();
		String sql="delete from cart where username=? and flowerId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setInt(2, flowerId);
			int x=ps.executeUpdate();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, null);
		}
		return 0;
	}
}
