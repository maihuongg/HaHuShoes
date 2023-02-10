package HaHuShoes.Model;

public class SellerModel {
	private int sellerId;
	private String sellerName;
	private int userId;
	private int status;
	private UserModel userModel;
	public SellerModel() {
		super();
	}
	public SellerModel(int sellerId, String sellerName, int userId, int status, UserModel userModel) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.userId = userId;
		this.status = status;
		this.userModel = userModel;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
}
