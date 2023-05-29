package HaHuShoes.Service.Impl;

import java.util.List;

import HaHuShoes.Dao.iOrderDao;
import HaHuShoes.Dao.Impl.OrderDaoImpl;
import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.InformationModel;
import HaHuShoes.Model.OrderDetailModel;
import HaHuShoes.Model.OrderModel;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iOrderService;

public class OrderServiceImpl implements iOrderService{

	iOrderDao orderDao = new OrderDaoImpl();

	@Override
	public void addOrder(UserModel u, CartModel cart, String receiveName, String phone, String adress) {
		// TODO Auto-generated method stub
		orderDao.addOrder(u, cart, receiveName, phone, adress);
	}

	@Override
	public int TotalModey() {
		// TODO Auto-generated method stub
		return orderDao.TotalModey();
	}

	@Override
	public List<OrderModel> findOrderByUserId(UserModel u) {
		// TODO Auto-generated method stub
		return orderDao.findOrderByUserId(u);
	}

	@Override
	public List<OrderDetailModel> findOrderDetialByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.findOrderDetialByOrderId(orderId);
	}

	@Override
	public int TotalModeyByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.TotalModeyByOrderId(orderId);
	}

	@Override
	public void ConfirmOrder(int orderId) {
		// TODO Auto-generated method stub
		orderDao.ConfirmOrder(orderId);
	}

	@Override
	public List<OrderModel> findOrderByUserIdHistory(UserModel u) {
		// TODO Auto-generated method stub
		return orderDao.findOrderByUserIdHistory(u);
	}

	@Override
	public List<OrderModel> findOrderConfirm(int index) {
		// TODO Auto-generated method stub
		return orderDao.findOrderConfirm(index);
	}

	@Override
	public int countAllOrderConfirm() {
		// TODO Auto-generated method stub
		return orderDao.countAllOrderConfirm();
	}

	@Override
	public void ConfirmOrderAdmin(int orderId) {
		// TODO Auto-generated method stub
		orderDao.ConfirmOrderAdmin(orderId);
	}

	@Override
	public List<OrderModel> findOrderBeingDelivered(int index) {
		// TODO Auto-generated method stub
		return orderDao.findOrderBeingDelivered(index);
	}

	@Override
	public int countAllOrderBeingDelivered() {
		// TODO Auto-generated method stub
		return orderDao.countAllOrderBeingDelivered();
	}

	@Override
	public List<OrderModel> findOrderCompleted(int index) {
		// TODO Auto-generated method stub
		return orderDao.findOrderCompleted(index);
	}

	@Override
	public int countAllOrderCompleted() {
		// TODO Auto-generated method stub
		return orderDao.countAllOrderCompleted();
	}

	@Override
	public List<InformationModel> findInformaionByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.findInformaionByOrderId(orderId);
	}

	
	
	

}
