package HaHuShoes.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iOrderDao;
import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.InformationModel;
import HaHuShoes.Model.ItemModel;
import HaHuShoes.Model.OrderDetailModel;
import HaHuShoes.Model.OrderModel;
import HaHuShoes.Model.UserModel;

public class OrderDaoImpl extends ConnectionDB implements iOrderDao{
	
	@Override
	public void addOrder(UserModel u, CartModel cart, String receiveName, String phone, String adress) {
		LocalDate curDate=LocalDate.now();
		String date=curDate.toString();
		try {
			//add order
			String sql="INSERT INTO [Order](userId, buyDate, totalMoney, status, prostatus) VALUES (?,?,?,?,?)";
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ps.setString(2, date);
			ps.setDouble(3, cart.getTotalMoney());
			ps.setInt(4, 0);
			ps.setInt(5, 0);
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
	
	public List<OrderModel> findOrderByUserId(UserModel u) {
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM [Order] WHERE userId=? and status=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ps.setInt(2, 0);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setDatetime(rs.getString("buyDate"));
				order.setTotalMoney(rs.getDouble("totalMoney"));
				order.setStatus(rs.getInt("status"));
				order.setProstatus(rs.getInt("prostatus"));
				orderList.add(order);
			}
			return orderList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<OrderModel> findOrderByUserIdHistory(UserModel u) {
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM [Order] WHERE userId=? and status=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ps.setInt(2, 1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setDatetime(rs.getString("buyDate"));
				order.setTotalMoney(rs.getDouble("totalMoney"));
				order.setStatus(rs.getInt("status"));
				order.setProstatus(rs.getInt("prostatus"));
				orderList.add(order);
			}
			return orderList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<OrderModel> findOrderConfirm(int index) {
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM [Order] WHERE prostatus=? order by orderId OFFSET ? ROW fetch next 3 rows only";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, (index - 1) * 3);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setDatetime(rs.getString("buyDate"));
				order.setTotalMoney(rs.getDouble("totalMoney"));
				order.setStatus(rs.getInt("status"));
				order.setProstatus(rs.getInt("prostatus"));
				orderList.add(order);
			}
			return orderList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int countAllOrderConfirm() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from [Order] where prostatus=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public List<OrderModel> findOrderBeingDelivered(int index) {
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM [Order] WHERE prostatus=? and status=? order by orderId OFFSET ? ROW fetch next 3 rows only";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, 0);
			ps.setInt(3, (index - 1) * 3);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setDatetime(rs.getString("buyDate"));
				order.setTotalMoney(rs.getDouble("totalMoney"));
				order.setStatus(rs.getInt("status"));
				order.setProstatus(rs.getInt("prostatus"));
				orderList.add(order);
			}
			return orderList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int countAllOrderBeingDelivered() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from [Order] where prostatus=? and status=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, 0);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public List<OrderModel> findOrderCompleted(int index) {
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM [Order] WHERE status=? order by orderId OFFSET ? ROW fetch next 3 rows only";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, (index - 1) * 3);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setDatetime(rs.getString("buyDate"));
				order.setTotalMoney(rs.getDouble("totalMoney"));
				order.setStatus(rs.getInt("status"));
				order.setProstatus(rs.getInt("prostatus"));
				orderList.add(order);
			}
			return orderList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int countAllOrderCompleted() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from [Order] where status=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public List<OrderDetailModel> findOrderDetialByOrderId(int orderId) {
		List<OrderDetailModel> orderdetailList = new ArrayList<OrderDetailModel>();
		String sql = "SELECT * FROM [OrderDetail] INNER JOIN [Product] ON OrderDetail.productId = Product.productId WHERE orderId = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDetailModel orderdetail = new OrderDetailModel();
				orderdetail.setOdetailId(rs.getInt("odetailId"));
				orderdetail.setOrderId(rs.getInt("orderId"));
				orderdetail.setProductId(rs.getInt("productId"));
				orderdetail.setProductName(rs.getString("productName"));
				orderdetail.setQuantity(rs.getInt("quantity"));
				orderdetail.setUnitPrice(rs.getDouble("unitPrice"));
				orderdetailList.add(orderdetail);
			}
			return orderdetailList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<InformationModel> findInformaionByOrderId(int orderId) {
		List<InformationModel> inforList = new ArrayList<InformationModel>();
		String sql = "SELECT * FROM [Information] WHERE orderId = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				InformationModel information = new InformationModel();
				information.setAdress(rs.getString("adress"));
				information.setId(rs.getInt("id"));
				information.setOrderId(rs.getInt("orderId"));
				information.setPhone(rs.getString("phone"));
				information.setReceiveName(rs.getString("receiveName"));
				information.setTotalMoney(rs.getDouble("totalMoney"));
				information.setUserId(rs.getInt("userId"));
				inforList.add(information);
			}
			return inforList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int TotalModeyByOrderId(int orderId) {
		
		String sql = " SELECT SUM(quantity*unitPrice) FROM [OrderDetail] WHERE orderId=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				return rSet.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	public void ConfirmOrder(int orderId) {
		
		String sql = "UPDATE [Order] SET status=? WHERE orderId=?";
		
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, orderId);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void ConfirmOrderAdmin(int orderId) {
		
		String sql = "UPDATE [Order] SET prostatus=? WHERE orderId=?";
		
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, orderId);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
