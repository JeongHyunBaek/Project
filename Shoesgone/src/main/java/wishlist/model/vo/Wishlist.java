package wishlist.model.vo;

public class Wishlist implements java.io.Serializable {
	private static final long serialVersionUID = 26L;
	
	private int wishlistNo;
	private int userNo;
	private int itemNo;
	private String itemEngName;
	private String itemKrName;
	private int price;
	
	public Wishlist() {}

	public Wishlist(int wishlistNo, int userNo, int itemNo, String itemEngName, String itemKrName, int price) {
		super();
		this.wishlistNo = wishlistNo;
		this.userNo = userNo;
		this.itemNo = itemNo;
		this.itemEngName = itemEngName;
		this.itemKrName = itemKrName;
		this.price = price;
	}

	public int getWishlistNo() {
		return wishlistNo;
	}

	public void setWishlistNo(int wishlistNo) {
		this.wishlistNo = wishlistNo;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Wishlist [wishlistNo=" + wishlistNo + ", userNo=" + userNo + ", itemNo=" + itemNo + ", itemEngName="
				+ itemEngName + ", itemKrName=" + itemKrName + ", price=" + price + "]";
	}
	
		
	

}