package beans;

public class OrderDetail implements java.io.Serializable{
	/*	
		id  number(11) NOT NULL primary key,
	   orderCode  varchar2(50) NOT NULL,
	   flowerID  number(11) NOT NULL,
	   flowerNumber  number(11) NOT NULL,
	   flowerPrice  number(7,2) NOT NULL,
	   subtotal  number(7,2) NOT NULL,
	   typeId  number(11) NOT NULL
	   
	*/
	
	private int id;
	private String orderCode;
	private int flowerId;
	private int flowerNumber;
	private String flowerName;
	private double flowerPrice;
	private double price;
	private double subTotal;
	private String typeId;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(int flowerId) {
		this.flowerId = flowerId;
	}
	public int getFlowerNumber() {
		return flowerNumber;
	}
	public void setFlowerNumber(int flowerNumber) {
		this.flowerNumber = flowerNumber;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public double getFlowerPrice() {
		return flowerPrice;
	}
	public void setFlowerPrice(double flowerPrice) {
		this.flowerPrice = flowerPrice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public OrderDetail(int id, String orderCode, int flowerId, int flowerNumber, String flowerName, double flowerPrice,
			double price, double subTotal, String typeId, String type) {
		super();
		this.id = id;
		this.orderCode = orderCode;
		this.flowerId = flowerId;
		this.flowerNumber = flowerNumber;
		this.flowerName = flowerName;
		this.flowerPrice = flowerPrice;
		this.price = price;
		this.subTotal = subTotal;
		this.typeId = typeId;
		this.type = type;
	}
	public OrderDetail() {
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderCode=" + orderCode + ", flowerId=" + flowerId + ", flowerNumber="
				+ flowerNumber + ", flowerName=" + flowerName + ", flowerPrice=" + flowerPrice + ", price=" + price
				+ ", subTotal=" + subTotal + ", typeId=" + typeId + ", type=" + type + "]";
	}
	
	
}
