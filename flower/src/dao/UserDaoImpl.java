package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import db.DButil;

public class UserDaoImpl implements UserDao{
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	@Override
	public int register(User user) {
		con=DButil.getCon();
		String sql="insert into userinfo values(seq_userinfo.nextval,?,?,sysdate,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getStatus());
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
	public User login(User user) {
		con=DButil.getCon();
		User u=null;
		String sql="select * from userinfo where username=? and pwd=? and status=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getStatus());
			rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setUserName(rs.getString(2));
				u.setEmail(rs.getString(5));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return null;
	}
	@Override
	public List<User> queryAll(int Upage,int pageSize) {
		List<User>list=new ArrayList<User>();
		User u=null;
		con=DButil.getCon();
		//String sql="select userid,username,status,email from userinfo where rownum>? and rownum<?";
		String sql="select userid,username,status,email from (select f.*,rownum r from userinfo f) where r>? and r<?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (Upage-1)*pageSize);
			ps.setInt(2, Upage*pageSize+1);
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setStatus(rs.getInt(3));
				u.setEmail(rs.getString(4));
				list.add(u);
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
	public int pageSum(int pageSize) {
		con=DButil.getCon();
		String sql="select count(*) from userinfo";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				int x=rs.getInt(1);
				if(x%pageSize==0){
					return x/pageSize;
				}else{
					return x/pageSize+1;
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
	public int deleteById(int userId) {
		con=DButil.getCon();
		String sql="delete from userinfo where userid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, userId);
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
	public boolean queryOneByName(String name) {
		con=DButil.getCon();
		String sql="select * from userinfo where username=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
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
}
