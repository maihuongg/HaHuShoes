package HaHuShoes.Dao;

import java.util.List;

import HaHuShoes.Model.SellerModel;

public interface iSellerDao {

	List<SellerModel> findAll();

	SellerModel findSellerId(int userId);

	SellerModel getSellerId(int sellerId);

	
}
