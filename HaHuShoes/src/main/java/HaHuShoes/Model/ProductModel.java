package HaHuShoes.Model;

import java.sql.Date;

public class ProductModel {
	private int productId;
	private String productName;
	private String productCode;
	private int categoryId;
	private String description;
	private double price;
	private int amount ;
	private int stock;
	private int wishlist;
	private int status;
	private String images;
	private Date createDate;

	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getWishlist() {
		return wishlist;
	}
	public void setWishlist(int wishlist) {
		this.wishlist = wishlist;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public CategoryModel getCategoryModel() {
		return categoryModel;
	}
	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	
	public ProductModel(int productId, String productName, String productCode, int categoryId, String description,
			double price, int amount, int stock, int wishlist, int status, String images, Date createDate,
			 CategoryModel categoryModel) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.categoryId = categoryId;
		this.description = description;
		this.price = price;
		this.amount = amount;
		this.stock = stock;
		this.wishlist = wishlist;
		this.status = status;
		this.images = images;
		this.createDate = createDate;
		
		this.categoryModel = categoryModel;
		
	}
	public ProductModel() {
		// TODO Auto-generated constructor stub
	}
	private CategoryModel categoryModel;

}
