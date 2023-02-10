package HaHuShoes.Service;

import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.UserModel;

public interface iOrderService {
	
	void addOrder(UserModel u, CartModel cart, String receiveName, String phone, String adress);
	
	int TotalModey();
}
