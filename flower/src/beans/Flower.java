package beans;
/*
 * CREATE TABLE  flower  (
   flowerID  number(11) NOT NULL primary key,
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
   typeId  number(11) NOT NULL
) ;
 * */

import java.sql.Date;
/*seq_flower.nextval,
'9900110',
'爱情',
'红玫瑰',
'9枝红玫瑰、绿叶，配草',
'单面花束：桔红色皱纸双层包装，红色蝴蝶结',
'带着美丽的爱情，来打动你的心，带着坚定的爱情，来守护你到心，用你最深情的眼神，让我倾心，用我最需要的温柔，载付你的爱',
'200510323403971312.jpg',
'35.00',
'30.00',
'全国',
to_date('2009-07-22 12:30:32','yyyy-MM-DD HH:MI:SS'),
1,
0*/
public class Flower implements java.io.Serializable{
	private String flowerId;
	private String flowerIsbn;
	private String flowerType;
	private String flowerName;
	private String flowerMaterial;
	private String flowerPack;
	private String flowerDesc;
	private String flowerImage;
	private double price;
	private double currentPrice;
	private String deliverArea;
	private Date noteTime;
	private String status;
	private String typeId;
	public Flower(String flowerId, String flowerIsbn, String flowerType, String flowerName, String flowerMaterial,
			String flowerPack, String flowerDesc, String flowerImage, double price, double currentPrice,
			String deliverArea, Date noteTime, String status, String typeId) {
		super();
		this.flowerId = flowerId;
		this.flowerIsbn = flowerIsbn;
		this.flowerType = flowerType;
		this.flowerName = flowerName;
		this.flowerMaterial = flowerMaterial;
		this.flowerPack = flowerPack;
		this.flowerDesc = flowerDesc;
		this.flowerImage = flowerImage;
		this.price = price;
		this.currentPrice = currentPrice;
		this.deliverArea = deliverArea;
		this.noteTime = noteTime;
		this.status = status;
		this.typeId = typeId;
	}
	public Flower() {
		super();
	}
	public String getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(String flowerId) {
		this.flowerId = flowerId;
	}
	public String getFlowerIsbn() {
		return flowerIsbn;
	}
	public void setFlowerIsbn(String flowerIsbn) {
		this.flowerIsbn = flowerIsbn;
	}
	public String getFlowerType() {
		return flowerType;
	}
	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public String getFlowerMaterial() {
		return flowerMaterial;
	}
	public void setFlowerMaterial(String flowerMaterial) {
		this.flowerMaterial = flowerMaterial;
	}
	public String getFlowerPack() {
		return flowerPack;
	}
	public void setFlowerPack(String flowerPack) {
		this.flowerPack = flowerPack;
	}
	public String getFlowerDesc() {
		return flowerDesc;
	}
	public void setFlowerDesc(String flowerDesc) {
		this.flowerDesc = flowerDesc;
	}
	public String getFlowerImage() {
		return flowerImage;
	}
	public void setFlowerImage(String flowerImage) {
		this.flowerImage = flowerImage;
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
	public String getDeliverArea() {
		return deliverArea;
	}
	public void setDeliverArea(String deliverArea) {
		this.deliverArea = deliverArea;
	}
	public Date getNoteTime() {
		return noteTime;
	}
	public void setNoteTime(Date noteTime) {
		this.noteTime = noteTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "Flower [flowerId=" + flowerId + ", flowerIsbn=" + flowerIsbn + ", flowerType=" + flowerType
				+ ", flowerName=" + flowerName + ", flowerMaterial=" + flowerMaterial + ", flowerPack=" + flowerPack
				+ ", flowerDesc=" + flowerDesc + ", flowerImage=" + flowerImage + ", price=" + price + ", currentPrice="
				+ currentPrice + ", deliverArea=" + deliverArea + ", noteTime=" + noteTime + ", status=" + status
				+ ", typeId=" + typeId + "]";
	}
	
	
}
