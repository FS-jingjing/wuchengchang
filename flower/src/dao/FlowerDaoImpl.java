package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Flower;
import beans.User;
import db.DButil;

public class FlowerDaoImpl implements FlowerDao, java.io.Serializable{
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public Flower getFlower(ResultSet rs) throws SQLException{
		Flower fl=new Flower();
		fl.setFlowerId(rs.getString(1));
		fl.setFlowerIsbn(rs.getString(2));
		fl.setFlowerType(rs.getString(3));
		fl.setFlowerName(rs.getString(4));
		fl.setFlowerMaterial(rs.getString(5));
		fl.setFlowerPack(rs.getString(6));
		fl.setFlowerDesc(rs.getString(7));
		fl.setFlowerImage(rs.getString(8));
		fl.setPrice(rs.getDouble(9));
		fl.setCurrentPrice(rs.getDouble(10));
		fl.setDeliverArea(rs.getString(11));
		fl.setNoteTime(rs.getDate(12));
		fl.setStatus(rs.getString(13));
		fl.setTypeId(rs.getString(14));
		return fl;
	}
	
	
	
	@Override
	public List<Flower> queryFlowerIndex() {
		List<Flower>list=new ArrayList<Flower>();
		con=DButil.getCon();
		String sql="select * from flower where rownum<=8 and typeid=0";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Flower fl=getFlower(rs);
				list.add(fl);
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
	public List<Flower> queryCakeIndex() {
		List<Flower>list=new ArrayList<Flower>();
		con=DButil.getCon();
		String sql="select * from flower where rownum<=4 and typeid=1";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Flower fl=getFlower(rs);
				list.add(fl);
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
	public List<Flower> queryLvzhihuahuiIndex() {
		List<Flower>list=new ArrayList<Flower>();
		con=DButil.getCon();
		String sql="select * from flower where rownum<=4 and typeid=2";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Flower fl=getFlower(rs);
				list.add(fl);
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
	public Flower queryOneByFlowerId(int flowerId) {
		con=DButil.getCon();
		String sql="select * from flower where flowerid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, flowerId);
			rs=ps.executeQuery();
			if(rs.next()){
				Flower fl=getFlower(rs);
				return fl;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return null;
	}
	
	@Override
	public int queryFlowerPageSum(int type, int pageSize) {
		con=DButil.getCon();
		String sql="select count(*) from flower where typeid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, type);
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
	public List<Flower> queryFlowerAll(int type,int pageSize,int page) {
		List<Flower>list=new ArrayList<Flower>();
		con=DButil.getCon();
		String sql="select * from (select f.*,rownum r from flower f where typeid=?) where r>? and r<?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, type);
			ps.setInt(2, page*pageSize);
			ps.setInt(3, (page+1)*pageSize+1);
			rs=ps.executeQuery();
			while(rs.next()){
				Flower fl=getFlower(rs);
				list.add(fl);
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
	public Flower queryOneByFlowerIsbn(String flowerIsbn) {
		con=DButil.getCon();
		String sql="select * from flower where flowerisbn=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, flowerIsbn);
			rs=ps.executeQuery();
			if(rs.next()){
				Flower fl=getFlower(rs);
				return fl;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return null;
	}
	
	@Override
	public List<Flower> queryAll() {
		List<Flower> list=new ArrayList<Flower>();
		con=DButil.getCon();
		String sql="select * from flower";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Flower fl=getFlower(rs);
				list.add(fl);
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
	public int queryCount() {
		con=DButil.getCon();
		String sql="select count(*) from flower";
		try {
			ps=con.prepareStatement(sql);
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
	public int queryPage(int PageSize) {
		int x=queryCount();
		if(x%PageSize==0){
			return x/PageSize;
		}else{
			return x/PageSize+1;
		}		
	}
	
	@Override
	public List<Flower> queryAllByPage(int page, int pageSize) {
		List<Flower>list=new ArrayList<Flower>();
		con=DButil.getCon();
		String sql="select * from (select f.*,rownum r from flower f) where r>? and r<?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (page-1)*pageSize);
			ps.setInt(2, page*pageSize+1);
			rs=ps.executeQuery();
			while(rs.next()){
				Flower fl=getFlower(rs);
				list.add(fl);
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
	public int deleteOneById(int flowerId) {
		con=DButil.getCon();
		String sql="delete from flower where flowerid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, flowerId);
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
	public int addFlower(Flower fl) {
		con=DButil.getCon();
		String sql="insert into flower values(seq_flower.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, fl.getFlowerIsbn());
			ps.setString(2, fl.getFlowerType());
			ps.setString(3, fl.getFlowerName());
			ps.setString(4, fl.getFlowerMaterial());
			ps.setString(5, fl.getFlowerPack());
			ps.setString(6, fl.getFlowerDesc());
			ps.setString(7, fl.getFlowerImage());
			ps.setDouble(8, fl.getPrice());
			ps.setDouble(9, fl.getCurrentPrice());
			ps.setString(10, fl.getDeliverArea());
			ps.setDate(11, fl.getNoteTime());
			ps.setInt(12, Integer.parseInt(fl.getStatus()));
			ps.setInt(13, Integer.parseInt(fl.getTypeId()));
			int x=ps.executeUpdate();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, null);
		}
		return 0;
	}
	/*		flowerID  number(11) NOT NULL primary key,
	   flowerISBN  varchar2(30) NOT NULL unique,
	   flowerType  varchar2(20) NOT NULL,
	   flowerName  varchar2(100) NOT NULL,
	   flowerMaterial  varchar2(255) NOT NULL,
	   flowerPack  varchar2(255) NOT NULL,
	   flowerDesc  varchar2(1204) NOT NULL,
	   flowerImage  varchar2(50) NOT NULL,
	   price  number(7,2) NOT NULL,
	   currentPrice  number(7,2) NOT NULL,
	   deliverArea  varchar2(50) NOT NULL,
	   noteTime  date NOT NULL,
	   status  number(11)  default 1,
	   typeId  number(11) NOT NULL*/
	@Override
	public int updateFlower(Flower fl) {
		con=DButil.getCon();
		//String sql="insert into flower values(seq_flower.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql="update flower set flowertype=?,flowername=?,flowerMaterial=?,flowerPack=?,flowerDesc=?,flowerImage=?,price=?,currentPrice=?,deliverArea=?,typeId=? where flowerISBN=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, fl.getFlowerType());
			ps.setString(2, fl.getFlowerName());
			ps.setString(3, fl.getFlowerMaterial());
			ps.setString(4, fl.getFlowerPack());
			ps.setString(5, fl.getFlowerDesc());
			ps.setString(6, fl.getFlowerImage());
			ps.setDouble(7, fl.getPrice());
			ps.setDouble(8, fl.getCurrentPrice());
			ps.setString(9, fl.getDeliverArea());
			ps.setInt(10, Integer.parseInt(fl.getTypeId()));
			ps.setString(11, fl.getFlowerIsbn());
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
