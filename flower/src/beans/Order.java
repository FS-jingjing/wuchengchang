package beans;

import java.sql.Date;

public class Order implements java.io.Serializable{
	private int orderId;
	private String orderCode;
	private String userName;
	private String mobilPhone;
	private String email;
	private String province;
	private String city;
	private String address;
	private double total;
	private Date orderTime;
	private int orderStatus;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobilPhone() {
		return mobilPhone;
	}
	public void setMobilPhone(String mobilPhone) {
		this.mobilPhone = mobilPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCode=" + orderCode + ", userName=" + userName + ", mobilPhone="
				+ mobilPhone + ", email=" + email + ", province=" + province + ", city=" + city + ", address=" + address
				+ ", total=" + total + ", orderTime=" + orderTime + ", orderStatus=" + orderStatus + "]";
	}
	public Order(int orderId, String orderCode, String userName, String mobilPhone, String email, String province,
			String city, String address, double total, Date orderTime, int orderStatus) {
		super();
		this.orderId = orderId;
		this.orderCode = orderCode;
		this.userName = userName;
		this.mobilPhone = mobilPhone;
		this.email = email;
		this.province = province;
		this.city = city;
		this.address = address;
		this.total = total;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
	}
	public Order() {
	}
	
}
