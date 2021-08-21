package categoryPage.model.vo;

import java.sql.Date;

public class BuyBid implements java.io.Serializable{

	private static final long serialVersionUID = 4L;
	
	private int buyBidNo;
	private int userNo;
	private int itemNo;
	private int shoesSize;
	private java.sql.Date regDate;
	private int price;
	private String address;
	
	public BuyBid() {
		super();
	}

	public BuyBid(int buyBidNo, int userNo, int itemNo, int shoesSize, Date regDate, int price, String address) {
		super();
		this.buyBidNo = buyBidNo;
		this.userNo = userNo;
		this.itemNo = itemNo;
		this.shoesSize = shoesSize;
		this.regDate = regDate;
		this.price = price;
		this.address = address;
	}

	public int getBuyBidNo() {
		return buyBidNo;
	}

	public void setBuyBidNo(int buyBidNo) {
		this.buyBidNo = buyBidNo;
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

	public int getShoesSize() {
		return shoesSize;
	}

	public void setShoesSize(int shoesSize) {
		this.shoesSize = shoesSize;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BuyBid [buyBidNo=" + buyBidNo + ", userNo=" + userNo + ", itemNo=" + itemNo + ", shoesSize=" + shoesSize
				+ ", regDate=" + regDate + ", price=" + price + ", address=" + address + "]";
	}
}
