package categoryPage.model.vo;

import java.sql.Date;

public class SellBid implements java.io.Serializable{

	private static final long serialVersionUID = 3L;

	private int sellBidNo;
	private int userNo;
	private int itemNo;
	private int shoesSize;
	private java.sql.Date regDate;
	private int price;
	private String penalty;
	private String address;
	
	public SellBid() {
		super();
	}

	public SellBid(int sellBidNo, int userNo, int itemNo, int shoesSize, Date regDate, int price, String penalty,
			String address) {
		super();
		this.sellBidNo = sellBidNo;
		this.userNo = userNo;
		this.itemNo = itemNo;
		this.shoesSize = shoesSize;
		this.regDate = regDate;
		this.price = price;
		this.penalty = penalty;
		this.address = address;
	}

	public int getSellBidNo() {
		return sellBidNo;
	}

	public void setSellBidNo(int sellBidNo) {
		this.sellBidNo = sellBidNo;
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

	public String getPenalty() {
		return penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
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
		return "SellBid [sellBidNo=" + sellBidNo + ", userNo=" + userNo + ", itemNo=" + itemNo + ", shoesSize="
				+ shoesSize + ", regDate=" + regDate + ", price=" + price + ", penalty=" + penalty + ", address="
				+ address + "]";
	}
}
