package dao;

import java.util.List;

import beans.User;

/*
 * userId  number(11) NOT NULL primary key,
   userName  varchar2(100) NOT NULL unique,
   pwd  varchar2(50) NOT NULL,
   regTime  date NOT NULL,
   email  varchar2(30) NOT NULL unique,
   status  number(11) NOT NULL
 * */
public interface UserDao {
	User login(User user);
	List<User>queryAll(int Upage,int pageSize);
	int register(User user);
	int pageSum(int Upage);
	int deleteById(int userId);
	boolean queryOneByName(String name);
}
