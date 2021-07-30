package information.model.vo;

public class Information implements java.io.Serializable {
	private static final long serialVersionUID = 23L;
	 
	private int userNo;
	private String userName;
	private String userId;
	private String userPwd;
	private String email;
	private String phone;
	private String address;
	private int shoesSize;
	
	public Information() {}

	
	
	
	public Information(int userNo, String userName, String userId, String userPwd, String email, String phone,
			String address, int shoesSize) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.shoesSize = shoesSize;
	}




	public int getUserNo() {
		return userNo;
	}




	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getUserPwd() {
		return userPwd;
	}




	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
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




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
	public String toString() {
		return "Information [userNo=" + userNo + ", userName=" + userName + ", userId=" + userId + ", userPwd="
				+ userPwd + ", email=" + email + ", phone=" + phone + ", address=" + address + ", shoesSize="
				+ shoesSize + "]";
	}
	
	
}
