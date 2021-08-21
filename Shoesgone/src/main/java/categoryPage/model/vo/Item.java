package categoryPage.model.vo;

import java.sql.Date;

public class Item implements java.io.Serializable {

	private static final long serialVersionUID = 2L;

	private int itemNo;
	private String itemEngName;
	private String itemKrName;
	private String brand;
	private String modelNo;
	private String shoesColors;
	private int price;
	private java.sql.Date regDate;
	private java.sql.Date dropDate;
	private String shoesSizes;
	private int views;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int itemNo, String itemEngName, String itemKrName, String brand, String modelNo, String shoesColors,
			int price, Date regDate, Date dropDate, String shoesSizes, int views) {
		super();
		this.itemNo = itemNo;
		this.itemEngName = itemEngName;
		this.itemKrName = itemKrName;
		this.brand = brand;
		this.modelNo = modelNo;
		this.shoesColors = shoesColors;
		this.price = price;
		this.regDate = regDate;
		this.dropDate = dropDate;
		this.shoesSizes = shoesSizes;
		this.views = views;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getShoesColors() {
		return shoesColors;
	}

	public void setShoesColors(String shoesColors) {
		this.shoesColors = shoesColors;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	public java.sql.Date getDropDate() {
		return dropDate;
	}

	public void setDropDate(java.sql.Date dropDate) {
		this.dropDate = dropDate;
	}

	public String getShoesSizes() {
		return shoesSizes;
	}

	public void setShoesSizes(String shoesSizes) {
		this.shoesSizes = shoesSizes;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemEngName=" + itemEngName + ", itemKrName=" + itemKrName + ", brand="
				+ brand + ", modelNo=" + modelNo + ", shoesColors=" + shoesColors + ", price=" + price + ", regDate="
				+ regDate + ", dropDate=" + dropDate + ", shoesSizes=" + shoesSizes + ", views=" + views + "]";
	}
}