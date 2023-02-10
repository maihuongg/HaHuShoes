package HaHuShoes.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iOrderDao;
import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.ItemModel;
import HaHuShoes.Model.UserModel;

public class OrderDaoImpl extends ConnectionDB implements iOrderDao{
	
	@Override
	public void addOrder(UserModel u, CartModel cart, String receiveName, String phone, String adress) {
		LocalDate curDate=LocalDate.now();
		String date=curDate.toString();
		try {
			//add order
			String sql="INSERT INTO [Order](userId, buyDate, totalMoney, status) VALUES (?,?,?,?)";
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ps.setString(2, date);
			ps.setDouble(3, cart.getTotalMoney());
			ps.setInt(4, 1);
			ps.executeUpdate();
			//lay id cua order cua add
			String sql1="SELECT TOP 1 orderId FROM [Order] ORDER BY orderId DESC";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs=ps1.executeQuery();
			//add bang OrderDetail
			if(rs.next()) {
				int orderId=rs.getInt("orderId");
				for(ItemModel i:cart.getItems()) {
					String sql2="INSERT INTO [OrderDetail](quantity, unitPrice, productId, orderId) VALUES (?,?,?,?)";
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, i.getQuantity());
					ps2.setDouble(2, i.getPrice());
					ps2.setInt(3, i.getProduct().getProductId());
					ps2.setInt(4, orderId);
					ps2.executeUpdate();
				}
				
				//add bang Information
				String sql4="INSERT INTO [Information](userId, receiveName, phone, adress, totalMoney, orderId) VALUES (?,?,?,?,?,?)";
				PreparedStatement ps4 = con.prepareStatement(sql4);
				ps4.setInt(1, u.getUserId());
				ps4.setString(2, receiveName);
				ps4.setString(3, phone);
				ps4.setString(4, adress);
				ps4.setDouble(5, (cart.getTotalMoney()+10000));
				ps4.setInt(6, orderId);
				ps4.executeUpdate();
			}
			//cap nhat lai so luong san pham
			String sql3="UPDATE Product SET amount=amount-?, wishlist=wishlist+? WHERE productId=?";
			PreparedStatement ps3 = con.prepareStatement(sql3);
			for(ItemModel i:cart.getItems()) {
				ps3.setInt(1, i.getQuantity());
				ps3.setInt(2, i.getQuantity());
				ps3.setInt(3, i.getProduct().getProductId());
				ps3.executeUpdate();
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public int TotalModey() {
		LocalDate curDate = LocalDate.now();
		String date = curDate.toString();
		String sql = " SELECT SUM(totalMoney) FROM [Order] WHERE buyDate=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, date);
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				return rSet.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	

}
