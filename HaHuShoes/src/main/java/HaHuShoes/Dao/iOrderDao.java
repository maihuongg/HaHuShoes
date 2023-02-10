package HaHuShoes.Dao;

import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.UserModel;

public interface iOrderDao {

	void addOrder(UserModel u, CartModel cart, String receiveName, String phone, String adress);

	int TotalModey();

	

}
