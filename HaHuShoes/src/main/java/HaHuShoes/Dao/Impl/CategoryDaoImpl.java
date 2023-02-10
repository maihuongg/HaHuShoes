package HaHuShoes.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iCategoryDao;
import HaHuShoes.Model.CategoryModel;

public class CategoryDaoImpl extends ConnectionDB implements iCategoryDao {

	@Override
	public List<CategoryModel> findAll() {
// TODO Auto-generated method stub
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "select * from Category";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setCategoryCode(rs.getString("categoryCode"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				category.setSellerId(rs.getInt("sellerId"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;

	}

	@Override
	public List<CategoryModel> findTop3() {
// TODO Auto-generated method stub
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "select top 3 * from Category";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				category.setSellerId(rs.getInt("sellerId"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;

	}

	@Override
	public CategoryModel get(int id) {
// TODO Auto-generated method stub
		String sql = "SELECT * FROM Category WHERE categoryId = ? ";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setCategoryCode(rs.getString("categoryCode"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));

				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO Category(categoryName,categoryCode,images,sellerId,status) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCategoryName());
			ps.setString(2, category.getCategoryCode());
			ps.setString(3, category.getImages());
			ps.setInt(4, category.getSellerId());
			ps.setInt(5, category.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int countAll() {
// TODO Auto-generated method stub
		String sql = "select count(*) from Category";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				return rSet.getInt(1);
			}
		} catch (Exception e) {
// TODO: handle exception
		}
		return 0;
	}

	@Override
	public void delete(int cateId) {
		String sql = "delete Category where categoryId = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cateId);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	@Override
	public void edit(CategoryModel category) {
		String sql = "UPDATE Category set categoryName=?,categoryCode=?,images=?,sellerId=? where categoryId=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCategoryName());
			ps.setString(2, category.getCategoryCode());
			ps.setString(3, category.getImages());
			ps.setInt(4, category.getSellerId());
			ps.setInt(5, category.getCategoryId());
			ps.executeUpdate();

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<CategoryModel> paging(int index) {
// TODO Auto-generated method stub
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "select * from Category order by categoryId OFFSET ? ROW fetch next 4 rows only";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
//truyền index-1*3 vào ? trên sql và 1- offset
			ps.setInt(1, (index - 1) * 4);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setCategoryCode(rs.getString("categoryCode"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				category.setSellerId(rs.getInt("sellerId"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;

	}
}