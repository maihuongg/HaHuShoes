package HaHuShoes.Service.Impl;

import java.util.List;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iSellerDao;
import HaHuShoes.Dao.Impl.SellerDaoImpl;
import HaHuShoes.Model.SellerModel;
import HaHuShoes.Service.iSellerService;

public class SellerServiceImpl extends ConnectionDB implements iSellerService{
	iSellerDao sellerDao= new SellerDaoImpl();
	@Override
	public List<SellerModel> findAll()
	{
		return sellerDao.findAll();
	}
	@Override
	public SellerModel findSellerId(int userId)
	{
		return sellerDao.findSellerId(userId);
	}
	@Override
	public SellerModel getSellerId(int sellerId)
	{
		return sellerDao.findSellerId(sellerId);
	}
}
