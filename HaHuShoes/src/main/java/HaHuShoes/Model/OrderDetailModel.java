package HaHuShoes.Model;

public class OrderDetailModel {
	
//	[odetailId] [int] IDENTITY(1,1) NOT NULL,
//	[quantity] [int] NULL,
//	[unitPrice] [float] NULL,
//	[productId] [int] NULL,
//	[orderId] [int] NULL,
	
	private int odetailId;
	private int quantity;
	private double unitPrice;
	private int productId;
	private int orderId;
	public OrderDetailModel() {
		super();
	}
	public OrderDetailModel(int odetailId, int quantity, double unitPrice, int productId, int orderId) {
		super();
		this.odetailId = odetailId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.productId = productId;
		this.orderId = orderId;
	}
	public int getOdetailId() {
		return odetailId;
	}
	public void setOdetailId(int odetailId) {
		this.odetailId = odetailId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
}
