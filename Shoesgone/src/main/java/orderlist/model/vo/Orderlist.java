package orderlist.model.vo;

import java.sql.Date;

public class Orderlist implements java.io.Serializable {
	private static final long serialVersionUID = 22L;
	
	private int orderNo;
	private String produceNo;
	private java.sql.Date orderDate;
	private String orderUser;
	private int price;
	private int count;
	private int delFee;
	private String progress;
	private String phone;
	private int point;
	private String address;
	private String payment;
	private int shoesSize;
	
	public Orderlist() {}

	public Orderlist(int orderNo, String produceNo, Date orderDate, String orderUser, int price, int count, int delFee,
			String progress, String phone, int point, String address, String payment, int shoesSize) {
		super();
		this.orderNo = orderNo;
		this.produceNo = produceNo;
		this.orderDate = orderDate;
		this.orderUser = orderUser;
		this.price = price;
		this.count = count;
		this.delFee = delFee;
		this.progress = progress;
		this.phone = phone;
		this.point = point;
		this.address = address;
		this.payment = payment;
		this.shoesSize = shoesSize;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getProduceNo() {
		return produceNo;
	}

	public void setProduceNo(String produceNo) {
		this.produceNo = produceNo;
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getDelFee() {
		return delFee;
	}

	public void setDelFee(int delFee) {
		this.delFee = delFee;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getShoesSize() {
		return shoesSize;
	}

	public void setShoesSize(int shoesSize) {
		this.shoesSize = shoesSize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Orderlist [orderNo=" + orderNo + ", produceNo=" + produceNo + ", orderDate=" + orderDate
				+ ", orderUser=" + orderUser + ", price=" + price + ", count=" + count + ", delFee=" + delFee
				+ ", progress=" + progress + ", phone=" + phone + ", point=" + point + ", address=" + address
				+ ", payment=" + payment + ", shoesSize=" + shoesSize + "]";
	}
	
	
	
	
	
}
