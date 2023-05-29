package HaHuShoes.Service;

import java.util.List;

import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.InformationModel;
import HaHuShoes.Model.OrderDetailModel;
import HaHuShoes.Model.OrderModel;
import HaHuShoes.Model.UserModel;

public interface iOrderService {
	
	void addOrder(UserModel u, CartModel cart, String receiveName, String phone, String adress);

	int TotalModey();
	
	List<OrderModel> findOrderByUserId(UserModel u);
	
	List<OrderDetailModel> findOrderDetialByOrderId(int orderId);
	
	List<OrderModel> findOrderByUserIdHistory(UserModel u);
	
	int TotalModeyByOrderId(int orderId);
	
	void ConfirmOrder(int orderId);
	
	List<OrderModel> findOrderConfirm(int index);
	
	int countAllOrderConfirm();
	
	void ConfirmOrderAdmin(int orderId);
	
	List<OrderModel> findOrderBeingDelivered(int index);
	
	int countAllOrderBeingDelivered();
	
	List<OrderModel> findOrderCompleted(int index);
	
	int countAllOrderCompleted();
	
	List<InformationModel> findInformaionByOrderId(int orderId);
}
