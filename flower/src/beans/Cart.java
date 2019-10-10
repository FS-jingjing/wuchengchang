package beans;

import java.io.Serializable;

/*﻿--userName 用户名
--flowerIsbn 鲜花编号
--flowerName 花名
--price 市场价
--currentPrice 当前价
--count 数量
 * */
public class Cart implements Serializable{
	private String userName;
	private int flowerId;
	private String flowerIsbn;
	private String flowerName;
	private double price;
	private double currentPrice;
	private int count;
	private String typeId;
	
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getFlowerIsbn() {
		return flowerIsbn;
	}

	public void setFlowerIsbn(String flowerIsbn) {
		this.flowerIsbn = flowerIsbn;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(int flowerId) {
		this.flowerId = flowerId;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Cart() {
	}

	public Cart(String userName, int flowerId, String flowerIsbn, String flowerName, double price, double currentPrice,
			int count) {
		super();
		this.userName = userName;
		this.flowerId = flowerId;
		this.flowerIsbn = flowerIsbn;
		this.flowerName = flowerName;
		this.price = price;
		this.currentPrice = currentPrice;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Cart [userName=" + userName + ", flowerId=" + flowerId + ", flowerIsbn=" + flowerIsbn + ", flowerName="
				+ flowerName + ", price=" + price + ", currentPrice=" + currentPrice + ",我提交了 count=" + count + "]";
	}
	
	
	
	
}
