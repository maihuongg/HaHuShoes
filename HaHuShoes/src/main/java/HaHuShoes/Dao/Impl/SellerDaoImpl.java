package HaHuShoes.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iSellerDao;
import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.SellerModel;

public class SellerDaoImpl extends ConnectionDB implements iSellerDao {
	@Override
	public List<SellerModel> findAll()
	{
		List<SellerModel> sellers = new ArrayList<SellerModel>();
		String sql = "select * from Seller";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SellerModel seller = new SellerModel();
				seller.setSellerId(rs.getInt("sellerId"));
				seller.setSellerName(rs.getString("sellerName"));
				seller.setUserId(rs.getInt("userId"));
				seller.setStatus(rs.getInt("status"));
				
				sellers.add(seller);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellers;
	}
	@Override
	public SellerModel findSellerId(int userId)
	{
//		SellerModel sellers = new SellerModel();
		String sql = "select * from Seller where userId= ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SellerModel seller = new SellerModel();
				seller.setSellerId(rs.getInt("sellerId"));
				seller.setSellerName(rs.getString("sellerName"));
				seller.setUserId(rs.getInt("userId"));
				seller.setStatus(rs.getInt("status"));
				return seller;
							}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public SellerModel getSellerId(int sellerId)
	{
//		SellerModel sellers = new SellerModel();
		String sql = "select * from Seller where sellerId= ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sellerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SellerModel seller = new SellerModel();
				seller.setSellerId(rs.getInt("sellerId"));
				seller.setSellerName(rs.getString("sellerName"));
				seller.setUserId(rs.getInt("userId"));
				seller.setStatus(rs.getInt("status"));
				return seller;
							}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
