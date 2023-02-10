package HaHuShoes.Service;

import java.util.List;

import HaHuShoes.Model.SellerModel;

public interface iSellerService {

	List<SellerModel> findAll();

	SellerModel findSellerId(int userId);

	SellerModel getSellerId(int sellerId);
	
}
