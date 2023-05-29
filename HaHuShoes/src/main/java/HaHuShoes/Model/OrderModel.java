package HaHuShoes.Model;

import java.sql.Date;

public class OrderModel {
	

	
	private int orderId;
	private int userId;
	private String datetime;
	private double totalMoney;
	private int status;
	private int prostatus;
	
	public OrderModel() {
		super();
	}

	public OrderModel(int orderId, int userId, String datetime, double totalMoney, int status, int prostatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.datetime = datetime;
		this.totalMoney = totalMoney;
		this.status = status;
		this.prostatus = prostatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getProstatus() {
		return prostatus;
	}

	public void setProstatus(int prostatus) {
		this.prostatus = prostatus;
	}
	
	
	
	
}
