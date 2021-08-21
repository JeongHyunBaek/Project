package orders.model.vo;

import java.sql.Date;

public class Orders implements java.io.Serializable {
	// Serial ID
	private static final long serialVersionUID = 2L;

	// Field
	private int ordersNo;
	private int sellerNo;
	private int itemNo;
	private int buyerNo;
	private java.sql.Date purDate;
	private int count;
	private String progress;
	private int price;
	private String address;
	private int size;
	private String phone;
	private int delFee;
	private String payment;
	private String etc;
	
	//Constructor
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int ordersNo, int sellerNo, int itemNo, int buyerNo, Date purDate, int count, String progress,
			int price, String address, int size, String phone, int delFee, String payment, String etc) {
		super();
		this.ordersNo = ordersNo;
		this.sellerNo = sellerNo;
		this.itemNo = itemNo;
		this.buyerNo = buyerNo;
		this.purDate = purDate;
		this.count = count;
		this.progress = progress;
		this.price = price;
		this.address = address;
		this.size = size;
		this.phone = phone;
		this.delFee = delFee;
		this.payment = payment;
		this.etc = etc;
	}
	//Getter and Setters
	public int getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(int ordersNo) {
		this.ordersNo = ordersNo;
	}

	public int getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getBuyerNo() {
		return buyerNo;
	}

	public void setBuyerNo(int buyerNo) {
		this.buyerNo = buyerNo;
	}

	public java.sql.Date getPurDate() {
		return purDate;
	}

	public void setPurDate(java.sql.Date purDate) {
		this.purDate = purDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDelFee() {
		return delFee;
	}

	public void setDelFee(int delFee) {
		this.delFee = delFee;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public String getEtc() {
		return etc;
	}
	
	public void setEtc(String etc) {
		this.etc = etc;
	}

	@Override
	public String toString() {
		return "Orders [ordersNo=" + ordersNo + ", sellerNo=" + sellerNo + ", itemNo=" + itemNo + ", buyerNo=" + buyerNo
				+ ", purDate=" + purDate + ", count=" + count + ", progress=" + progress + ", price=" + price
				+ ", address=" + address + ", size=" + size + ", phone=" + phone + ", delFee=" + delFee + ", payment="
				+ payment + "]";
	}
	
}
