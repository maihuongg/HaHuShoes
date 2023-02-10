package HaHuShoes.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iCategoryDao;
import HaHuShoes.Dao.iProductDao;
import HaHuShoes.Dao.iSellerDao;
import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Model.SellerModel;
import HaHuShoes.Model.ProductModel;

public class ProductDaoImpl extends ConnectionDB implements iProductDao {
	Connection conn = null;
	PreparedStatement pStatement = null;
	ResultSet rSet = null;

	@Override
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "select * from Product";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setCategoryId(rs.getInt("categoryId"));

				product.setDescription(rs.getString("descriptions"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setWishlist(rs.getInt("wishlist"));

				product.setStatus(rs.getInt("status"));
				product.setImages(rs.getString("images"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setSellerId(rs.getInt("sellerId"));
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;

	}

	@Override
	public List<ProductModel> findTrendyProduct() {
		// TODO Auto-generated method stub
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "select TOP 4 * from Product where wishlist <= (select max(wishlist) from Product)";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setCategoryId(rs.getInt("categoryId"));

				product.setDescription(rs.getString("descriptions"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setWishlist(rs.getInt("wishlist"));

				product.setStatus(rs.getInt("status"));
				product.setImages(rs.getString("images"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setSellerId(rs.getInt("sellerId"));
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;

	}

	@Override
	public List<ProductModel> findJustArrived() {
		// TODO Auto-generated method stub
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "Select TOP 4* from Product Order By createDate DESC";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setCategoryId(rs.getInt("categoryId"));

				product.setDescription(rs.getString("descriptions"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setWishlist(rs.getInt("wishlist"));

				product.setStatus(rs.getInt("status"));
				product.setImages(rs.getString("images"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setSellerId(rs.getInt("sellerId"));
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;

	}

	@Override
	public ProductModel findoneId(int productId) {
		// TODO Auto-generated method stub
		// show chi tiết 1 sản phẩm
		String sql = "SELECT * FROM Product WHERE productId = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			iCategoryDao categoryDao = new CategoryDaoImpl();
			iSellerDao sellerDao = new SellerDaoImpl();
			while (rs.next()) {
				ProductModel productoneId = new ProductModel();
				CategoryModel categoryModel = new CategoryModel();
				SellerModel sellerModel = new SellerModel();
				productoneId.setProductId(rs.getInt("productId"));
				Integer idCate = rs.getInt("categoryId");
				categoryModel = categoryDao.get(idCate);

				productoneId.setProductName(rs.getString("productName"));
				productoneId.setProductCode(rs.getString("productCode"));
				productoneId.setCategoryId(idCate);
				productoneId.setDescription(rs.getString("descriptions"));
				productoneId.setPrice(rs.getDouble("price"));
				productoneId.setAmount(rs.getInt("amount"));
				productoneId.setStock(rs.getInt("stock"));
				productoneId.setImages(rs.getString("images"));
				productoneId.setWishlist(rs.getInt("wishlist"));
				productoneId.setStatus(rs.getInt("status"));
				productoneId.setCreateDate(rs.getDate("createDate"));
				
				productoneId.setSellerId(rs.getInt("sellerId"));
				productoneId.setCategoryModel(categoryModel);
				return productoneId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		// TODO Auto-generated method stub
		List<ProductModel> productPagingList = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM Product order by productId OFFSET ? ROW fetch next 3 rows only";
		try {
			conn = super.getConnectionW();// mở kết nối
			pStatement = conn.prepareStatement(sql);// ném câu qery qua sql

			// truyền index-1*3 vào ? trên sql và 1- offset
			pStatement.setInt(1, (index - 1) * 3);
			rSet = pStatement.executeQuery();
			iCategoryDao categoryDao = new CategoryDaoImpl();
			while (rSet.next()) {
				ProductModel productModel = new ProductModel();
				CategoryModel categoryModel = new CategoryModel();
				Integer idCate = rSet.getInt("categoryId");
				categoryModel = categoryDao.get(idCate);
				productModel.setProductId(rSet.getInt("productId"));
				productModel.setProductName(rSet.getString("productName"));
				productModel.setProductCode(rSet.getString("productCode"));
				productModel.setCategoryId(idCate);
				productModel.setDescription(rSet.getString("descriptions"));
				productModel.setPrice(rSet.getDouble("price"));
				productModel.setAmount(rSet.getInt("amount"));
				productModel.setStock(rSet.getInt("stock"));
				productModel.setImages(rSet.getString("images"));
				productModel.setWishlist(rSet.getInt("wishlist"));
				productModel.setStatus(rSet.getInt("status"));
				productModel.setCreateDate(rSet.getDate("createDate"));
				productModel.setSellerId(rSet.getInt("sellerId"));

				productModel.setCategoryModel(categoryModel);
				productPagingList.add(productModel);
			}
			return productPagingList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Product";
		try {
			conn = super.getConnectionW();
			pStatement = conn.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			while (rSet.next()) {
				return rSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<ProductModel> findProductbyCateId(int cateId, int index) {
		String sql = "select * from Product where categoryId = ? ORDER BY productId OFFSET ? rows fetch next 3 rows only";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			int indexp = (index - 1) * 3;
			ps.setInt(2, indexp);
			ResultSet rs = ps.executeQuery();
			iCategoryDao categoryDao = new CategoryDaoImpl();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				CategoryModel category = new CategoryModel();
				Integer idCate = rs.getInt("categoryId");
				category = categoryDao.get(idCate);
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setCategoryId(idCate);
				product.setDescription(rs.getString("descriptions"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImages(rs.getString("images"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setSellerId(rs.getInt("sellerId"));
				product.setCategoryModel(category);
				products.add(product);
			}
			return products;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductModel> SearchProduct(String txtsearch, int index) {
		iCategoryDao categoryDao = new CategoryDaoImpl();
		List<ProductModel> productList = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM Product WHERE productName LIKE ? ORDER BY productId OFFSET ? rows fetch next 3 rows only";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + txtsearch + "%");
			int indexp = (index - 1) * 3;
			ps.setInt(2, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				CategoryModel category = new CategoryModel();
				Integer idCate = rs.getInt("categoryId");
				category = categoryDao.get(idCate);
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setCategoryId(idCate);
				product.setDescription(rs.getString("descriptions"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImages(rs.getString("images"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setSellerId(rs.getInt("sellerId"));
				product.setCategoryModel(category);
				productList.add(product);
			}

			return productList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countSearchProduct(String txtsearch) {
		String sql = "SELECT count(*) FROM Product WHERE productName LIKE ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + txtsearch + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}

		return 0;
	}

	@Override
	public int countProductByCategory(int cateId) {
		String sql = "SELECT count(*) FROM Product WHERE categoryId = ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}

		return 0;
	}

	@Override
	public void insert(ProductModel product) {
		iCategoryDao categoryDao = new CategoryDaoImpl();
		String sql = "INSERT INTO Product(productName,productCode,categoryId,"
				+ "descriptions,price,amount,stock,images,status)" + " VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCode());
			ps.setInt(3, product.getCategoryId());
			ps.setString(4, product.getDescription());
			ps.setDouble(5, product.getPrice());
			ps.setInt(6, product.getAmount());
			ps.setInt(7, product.getStock());
			ps.setString(8, product.getImages());
//				ps.setDate(9, product.getCreateDate());
			ps.setInt(9, product.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void edit(ProductModel product) {
		iCategoryDao categoryDao = new CategoryDaoImpl();
		String sql = "UPDATE Product SET productName=?,productCode=?,categoryId=?,"
				+ "descriptions=?,price=?,amount=?,stock=?,images=?" + " WHERE productId=? ";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCode());
			ps.setInt(3, product.getCategoryId());
			ps.setString(4, product.getDescription());
			ps.setDouble(5, product.getPrice());
			ps.setInt(6, product.getAmount());
			ps.setInt(7, product.getStock());
			ps.setString(8, product.getImages());
////				ps.setDate(9, product.getCreateDate());
//				ps.setInt(9, product.getStatus());
			ps.setInt(9, product.getProductId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int productId) {
		String sql = "DELETE Product WHERE productId = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductModel> pagingProductManagement(int index) {
		// TODO Auto-generated method stub
		List<ProductModel> productPagingList = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM Product order by productId OFFSET ? ROW fetch next 5 rows only";
		try {
			conn = super.getConnectionW();// mở kết nối
			pStatement = conn.prepareStatement(sql);// ném câu qery qua sql

			// truyền index-1*3 vào ? trên sql và 1- offset
			pStatement.setInt(1, (index - 1) * 5);
			rSet = pStatement.executeQuery();
			iCategoryDao categoryDao = new CategoryDaoImpl();
			while (rSet.next()) {
				ProductModel productModel = new ProductModel();
				CategoryModel categoryModel = new CategoryModel();
				Integer idCate = rSet.getInt("categoryId");
				categoryModel = categoryDao.get(idCate);
				productModel.setProductId(rSet.getInt("productId"));
				productModel.setProductName(rSet.getString("productName"));
				productModel.setProductCode(rSet.getString("productCode"));
				productModel.setCategoryId(idCate);
				productModel.setDescription(rSet.getString("descriptions"));
				productModel.setPrice(rSet.getDouble("price"));
				productModel.setAmount(rSet.getInt("amount"));
				productModel.setStock(rSet.getInt("stock"));
				productModel.setImages(rSet.getString("images"));
				productModel.setWishlist(rSet.getInt("wishlist"));
				productModel.setStatus(rSet.getInt("status"));
				productModel.setCreateDate(rSet.getDate("createDate"));
				productModel.setSellerId(rSet.getInt("sellerId"));

				
				productModel.setCategoryModel(categoryModel);
				productPagingList.add(productModel);
			}
			return productPagingList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ProductModel productbySellerId(int sellerId) {
		// TODO Auto-generated method stub
		// show chi tiết 1 sản phẩm
		String sql = "SELECT * FROM Product WHERE sellerId = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sellerId);
			ResultSet rs = ps.executeQuery();
			iCategoryDao categoryDao = new CategoryDaoImpl();
			while (rs.next()) {
				ProductModel productsellerId = new ProductModel();
				CategoryModel categoryModel = new CategoryModel();
				productsellerId.setProductId(rs.getInt("productId"));
				Integer idCate = rs.getInt("categoryId");
				categoryModel = categoryDao.get(idCate);

				productsellerId.setProductName(rs.getString("productName"));
				productsellerId.setProductCode(rs.getString("productCode"));
				productsellerId.setCategoryId(idCate);
				productsellerId.setDescription(rs.getString("descriptions"));
				productsellerId.setPrice(rs.getDouble("price"));
				productsellerId.setAmount(rs.getInt("amount"));
				productsellerId.setStock(rs.getInt("stock"));
				productsellerId.setImages(rs.getString("images"));
				productsellerId.setWishlist(rs.getInt("wishlist"));
				productsellerId.setStatus(rs.getInt("status"));
				productsellerId.setCreateDate(rs.getDate("createDate"));
				productsellerId.setSellerId(rs.getInt("sellerId"));
				productsellerId.setCategoryModel(categoryModel);
				return productsellerId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	@Override
	public List<ProductModel> findAllbySellerId(int sellerId,int index) {
		// TODO Auto-generated method stub
		iCategoryDao categoryDao = new CategoryDaoImpl();
		iSellerDao sellerDao= new SellerDaoImpl();
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "select * from Product where sellerId = ? ORDER BY productId OFFSET ? rows fetch next 5 rows only";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sellerId);
			int indexp = (index - 1) * 5;
			ps.setInt(2, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				CategoryModel category = new CategoryModel();
				SellerModel sellerModel =new SellerModel();
				Integer idCate = rs.getInt("categoryId");
				category = categoryDao.get(idCate);
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setCategoryId(idCate);
				product.setDescription(rs.getString("descriptions"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImages(rs.getString("images"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				Integer idSeller = rs.getInt("sellerId");
				sellerModel=sellerDao.getSellerId(idSeller);
				
				
				product.setSellerModel(sellerModel);
				product.setSellerId(rs.getInt("sellerId"));
				product.setCategoryModel(category);
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;

	}
	@Override
	public int countProductBySellerId(int sellerId) {
		String sql = "SELECT count(*) FROM Product WHERE sellerId = ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sellerId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}

		return 0;
	}
	
	@Override
	public List<ProductModel> findProductbyCateIdTop4(int cateId) {
		// TODO Auto-generated method stub
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "select TOP 4 * from Product where categoryId=? ORDER BY  wishlist DESC";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setCategoryId(rs.getInt("categoryId"));

				product.setDescription(rs.getString("descriptions"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setWishlist(rs.getInt("wishlist"));

				product.setStatus(rs.getInt("status"));
				product.setImages(rs.getString("images"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setSellerId(rs.getInt("sellerId"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	@Override
	public ProductModel findCateIdByProductId(int id) {
		String sql = "Select * from Product where productId=?";
		try {
			ProductModel product = new ProductModel();
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu sql vào cho phát Prepare
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setCategoryId(rs.getInt("categoryId"));

				product.setDescription(rs.getString("descriptions"));
				product.setPrice(rs.getDouble("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setWishlist(rs.getInt("wishlist"));

				product.setStatus(rs.getInt("status"));
				product.setImages(rs.getString("images"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setSellerId(rs.getInt("sellerId"));
				return product;
			}
		}catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}
	
	public static void main(String[] args) {
		iProductDao productsDao = new ProductDaoImpl();
		System.out.println(productsDao.pagingProduct(2));

	}

}
