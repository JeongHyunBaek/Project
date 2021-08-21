package itemregsta.model.vo;

import java.sql.Date;

public class ItemRegSta implements java.io.Serializable {
	// Serial ID
	private static final long serialVersionUID = 1L;
	
	// Field
	private int regNo;
	private int userNo;
	private int itemNo;
	private int size;
	private java.sql.Date regDate;
	private int price;
	private String address;
	private String penalty;
	
	// Constructor
	public ItemRegSta() {}

	public ItemRegSta(int regNo, int userNo, int itemNo, int size, Date regDate, int price, String address, String penalty) {
		super();
		this.regNo = regNo;
		this.userNo = userNo;
		this.itemNo = itemNo;
		this.size = size;
		this.regDate = regDate;
		this.price = price;
		this.address = address;
		this.penalty = penalty;
	}

	// Getter & Setter
	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPenalty() {
		return penalty;
	}
	
	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}

	// toString()
	@Override
	public String toString() {
		return "ItemRegSta [regNo=" + regNo + ", userNo=" + userNo + ", itemNo=" + itemNo
				+ ", size=" + size + ", regDate=" + regDate + ", price=" + price + ", address=" + address + ", penalty=" + penalty + "]";
	}
	
}
