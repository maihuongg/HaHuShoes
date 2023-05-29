package HaHuShoes.Service;

import java.util.List;

import HaHuShoes.Model.ProductCategoryDTO;
import HaHuShoes.Model.ProductModel;

public interface iProductService {
	List<ProductModel> findAll();
	//trendy product- top 4 wishlist
	List<ProductModel> findTrendyProduct();
//	Just Arrived- nhung san pham moi ra mat
	List <ProductModel> findJustArrived();
	
	ProductModel findoneId(int productId);
	List<ProductModel> pagingProduct(int index);
	int countAll();
	List<ProductModel> SearchProduct(String txtsearch, int index);
	int countSearchProduct(String txtsearch);
	int countProductByCategory(int cateId);
	List<ProductModel> findProductbyCateId(int cateId, int index);
	List<ProductModel> pagingProductManagement(int index);
	void delete(int producId);
	void edit(ProductModel product);
	void insert(ProductModel product);
	//ProductModel productbySellerId(int sellerId);
	
	//List<ProductModel> findAllbySellerId(int sellerId, int index);
	//int countProductBySellerId(int sellerId);
	
	ProductModel findCateIdByProductId(int id);
	List<ProductModel> findProductbyCateIdTop4(int cateId);
	List<ProductCategoryDTO > getProductCountByCategory();
}
