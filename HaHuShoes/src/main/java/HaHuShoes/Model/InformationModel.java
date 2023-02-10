package HaHuShoes.Model;

public class InformationModel {
	
	private int id;
	private int userId;
	private String receiveName;
	private String phone;
	private String adress;
	private double totalMoney;
	private int orderId;
	public InformationModel() {
		super();
	}
	
	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public InformationModel(int id, int userId, String receiveName, String phone, String adress, double totalMoney,
			int orderId) {
		super();
		this.id = id;
		this.userId = userId;
		this.receiveName = receiveName;
		this.phone = phone;
		this.adress = adress;
		this.totalMoney = totalMoney;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
}
