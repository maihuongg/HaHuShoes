package HaHuShoes.Service.Impl;

import HaHuShoes.Dao.iOrderDao;
import HaHuShoes.Dao.Impl.OrderDaoImpl;
import HaHuShoes.Model.CartModel;
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

	
	
	

}
