package HaHuShoes.Model;

import java.sql.Date;

public class OrderModel {
	
//	[orderId] [int] IDENTITY(1,1) NOT NULL,
//	[userId] [int] NULL,
//	[buyDate] [datetime] NULL,
//	[totalMoney] [float] NULL,
//	[status] [int] NULL,
	
	private int orderId;
	private int userId;
	private Date datetime;
	private double totalMoney;
	private int status;
	public OrderModel() {
		super();
	}
	public OrderModel(int orderId, int userId, Date datetime, double totalMoney, int status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.datetime = datetime;
		this.totalMoney = totalMoney;
		this.status = status;
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
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
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
	
	
}
