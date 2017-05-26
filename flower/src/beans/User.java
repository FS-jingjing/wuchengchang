package beans;

import java.sql.Date;

public class User implements java.io.Serializable{
	 	/*	userId  number(11) NOT NULL primary key,
	   		userName  varchar2(100) NOT NULL unique,
	   		pwd  varchar2(50) NOT NULL,
	   		regTime  date NOT NULL,
	   		email  varchar2(30) NOT NULL unique,
	   		status  number(11) NOT NULL
	 	 */
	
	private int userId;
	private String userName;
	private String password;
	private Date regtime;
	private String email;
	private int status;
	public long getUserId() {
		return userId;
	}
	public void setUserId(int userid) {
		this.userId = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User(int userid, String username, String password, Date regtime, String email, int status) {
		super();
		this.userId = userid;
		this.userName = username;
		this.password = password;
		this.regtime = regtime;
		this.email = email;
		this.status = status;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [userid=" + userId + ", username=" + userName + ", password=" + password + ", regtime=" + regtime
				+ ", email=" + email + ", status=" + status + "]";
	}
}
