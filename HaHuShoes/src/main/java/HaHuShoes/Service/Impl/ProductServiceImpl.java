package HaHuShoes.Service.Impl;

import java.util.List;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iProductDao;
import HaHuShoes.Dao.Impl.ProductDaoImpl;
import HaHuShoes.Model.ProductCategoryDTO;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Service.iProductService;

public class ProductServiceImpl extends ConnectionDB implements iProductService {
	iProductDao productDao = new ProductDaoImpl();

	@Override
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public List<ProductModel> findTrendyProduct() {
		// TODO Auto-generated method stub
		return productDao.findTrendyProduct();
	}

	@Override
	public List<ProductModel> findJustArrived() {
		// TODO Auto-generated method stub
		return productDao.findJustArrived();
	}

	@Override
	public ProductModel findoneId(int productId) {
		// TODO Auto-generated method stub
		return productDao.findoneId(productId);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return productDao.countAll();
	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		// TODO Auto-generated method stub
		return productDao.pagingProduct(index);
	}

	@Override
	public List<ProductModel> findProductbyCateId(int cateId, int index) {
		// TODO Auto-generated method stub
		return productDao.findProductbyCateId(cateId, index);
	}

	@Override
	public int countProductByCategory(int cateId) {
		// TODO Auto-generated method stub
		return productDao.countProductByCategory(cateId);
	}

	@Override
	public int countSearchProduct(String txtsearch) {
		// TODO Auto-generated method stub
		return productDao.countSearchProduct(txtsearch);
	}

	@Override
	public List<ProductModel> SearchProduct(String txtsearch, int index) {
		// TODO Auto-generated method stub
		return productDao.SearchProduct(txtsearch, index);
	}

	@Override
	public void insert(ProductModel product) {
		productDao.insert(product);

	}

	@Override
	public void edit(ProductModel product) {
		productDao.edit(product);

	}

	@Override
	public void delete(int producId) {
		productDao.delete(producId);

	}

	@Override
	public List<ProductModel> pagingProductManagement(int index) {
		// TODO Auto-generated method stub
		return productDao.pagingProductManagement(index);
	}

	/*
	 * @Override public ProductModel productbySellerId(int sellerId) { return
	 * productDao.productbySellerId(sellerId); } public List<ProductModel>
	 * findAllbySellerId(int sellerId, int index) { return
	 * productDao.findAllbySellerId(sellerId, index); }
	 * 
	 * @Override public int countProductBySellerId(int sellerId) { return
	 * productDao.countProductBySellerId(sellerId); }
	 */

	@Override
	public ProductModel findCateIdByProductId(int id) {
		// TODO Auto-generated method stub
		return productDao.findCateIdByProductId(id);
	}

	@Override
	public List<ProductModel> findProductbyCateIdTop4(int cateId) {
		// TODO Auto-generated method stub
		return productDao.findProductbyCateIdTop4(cateId);
	}
	
	@Override
	public List<ProductCategoryDTO> getProductCountByCategory() {
		// TODO Auto-generated method stub
		return productDao.getProductCountByCategory();
	}
}
