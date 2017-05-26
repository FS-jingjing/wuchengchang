package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DButil {
	static Properties pro=new Properties();
	static{
		try {
			pro.load(DButil.class.getClassLoader().getResourceAsStream("DBDriver.properties"));
			Class.forName(pro.getProperty("oracledriver"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon(){
		try {
			Connection con=DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(Connection con,Statement stat,ResultSet rs){
		try {
			if(rs!=null){rs.close();}
			if(stat!=null){stat.close();}
			if(con!=null){con.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		System.out.println(DButil.connect());
//	}
}
