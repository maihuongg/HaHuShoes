package HaHuShoes.Dao;

import java.util.List;

import HaHuShoes.Model.ProductCategoryDTO;
import HaHuShoes.Model.ProductModel;

public interface iProductDao {
	List<ProductModel> findAll();
	//Trandy Product -Top 4 Wishlist
	List<ProductModel> findTrendyProduct();
	
	//	Just Arrived- nhung san pham moi ra mat
	List <ProductModel> findJustArrived();
	ProductModel findoneId(int productId);
	int countAll();
	List<ProductModel> pagingProduct(int index);
	int countProductByCategory(int cateId);
	int countSearchProduct(String txtsearch);
	List<ProductModel> SearchProduct(String txtsearch, int index);
	List<ProductModel> findProductbyCateId(int cateId, int index);
	List<ProductModel> pagingProductManagement(int index);
	void delete(int productId);
	void edit(ProductModel product);
	void insert(ProductModel product);
	//ProductModel productbySellerId(int sellerId);
	
	//List<ProductModel> findAllbySellerId(int sellerId, int index);
	//int countProductBySellerId(int sellerId);
	ProductModel findCateIdByProductId(int id);
	List<ProductModel> findProductbyCateIdTop4(int cateId);
	
	List<ProductCategoryDTO > getProductCountByCategory();
}
