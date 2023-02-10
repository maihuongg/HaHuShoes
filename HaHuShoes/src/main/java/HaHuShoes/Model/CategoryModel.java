package HaHuShoes.Model;

public class CategoryModel {
	private int categoryId;
	private String categoryName;
	private String categoryCode;
	private String images;
	private int status;
	private int sellerId;
	private SellerModel sellerModel ;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public SellerModel getSellerModel() {
		return sellerModel;
	}
	public void setSellerModel(SellerModel sellerModel) {
		this.sellerModel = sellerModel;
	}
	public CategoryModel(int categoryId, String categoryName, String categoryCode, String images, int status,
			int sellerId, SellerModel sellerModel) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryCode = categoryCode;
		this.images = images;
		this.status = status;
		this.sellerId = sellerId;
		this.sellerModel = sellerModel;
	}
	public CategoryModel() {
		super();
	}
	
}
