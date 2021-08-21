package orderlist.model.vo;

import java.sql.Date;

public class Orderlist implements java.io.Serializable {
	private static final long serialVersionUID = 22L;
	
	private int ordersNo;
	private int sellerNo;
	private int itemNo;
	private int buyerNo;
	private java.sql.Date purDate;
	private int count;
	private String progress;
	private int price;
	private String address;
	private int shoesSize;
	private String phone;
	private int delFee;
	private String payment;
	private int point;
	private String itemEngName;
	private String itemKrName;
	
	public Orderlist() {}

	public Orderlist(int ordersNo, int sellerNo, int itemNo, int buyerNo, Date purDate, int count, String progress,
			int price, String address, int shoesSize, String phone, int delFee, String payment, int point,
			String itemEngName, String itemKrName) {
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
		this.shoesSize = shoesSize;
		this.phone = phone;
		this.delFee = delFee;
		this.payment = payment;
		this.point = point;
		this.itemEngName = itemEngName;
		this.itemKrName = itemKrName;
	}

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

	public int getShoesSize() {
		return shoesSize;
	}

	public void setShoesSize(int shoesSize) {
		this.shoesSize = shoesSize;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getItemEngName() {
		return itemEngName;
	}

	public void setItemEngName(String itemEngName) {
		this.itemEngName = itemEngName;
	}

	public String getItemKrName() {
		return itemKrName;
	}

	public void setItemKrName(String itemKrName) {
		this.itemKrName = itemKrName;
	}

	@Override
	public String toString() {
		return "Orderlist [ordersNo=" + ordersNo + ", sellerNo=" + sellerNo + ", itemNo=" + itemNo + ", buyerNo="
				+ buyerNo + ", purDate=" + purDate + ", count=" + count + ", progress=" + progress + ", price=" + price
				+ ", address=" + address + ", shoesSize=" + shoesSize + ", phone=" + phone + ", delFee=" + delFee
				+ ", payment=" + payment + ", point=" + point + ", itemEngName=" + itemEngName + ", itemKrName="
				+ itemKrName + "]";
	}

	
	
	
}
