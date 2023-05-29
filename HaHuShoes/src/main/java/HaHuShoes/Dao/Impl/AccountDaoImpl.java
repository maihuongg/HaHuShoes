package HaHuShoes.Dao.Impl;

import java.io.Console;
import java.nio.channels.NonReadableChannelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.tribes.transport.RxTaskPool;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iAccountDao;
import HaHuShoes.Model.CountByRoleName;
import HaHuShoes.Model.UserModel;

public class AccountDaoImpl extends ConnectionDB implements iAccountDao {
	// TODO Auto-generated method stub
	//UserModel newUser = new UserModel();

	@Override
	public UserModel findbyUsername(String username) {
		String sql = "Select * from Users where userName=?";
		try {
			UserModel acc = new UserModel();
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu sql vào cho phát Prepare
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				acc.setUserId(rs.getInt("userId"));
				acc.setUserName(rs.getString("userName"));
				acc.setEmail(rs.getString("email"));
				acc.setFullName(rs.getString("fullName"));
				acc.setPassword(rs.getString("password"));
				acc.setImages(rs.getString("images"));
				acc.setUserCode(rs.getString("userCode"));
				acc.setRoleId(rs.getInt("roleId"));
			
				acc.setStatus(rs.getInt("status"));
				// chua set mot so thuoc tinh khac
				return acc;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "Select * from Users ";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu sql vào cho phát Prepare
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel userModel = new UserModel();
				userModel.setUserId(rs.getInt("userId"));
				userModel.setUserName(rs.getString("userName"));
				userModel.setEmail(rs.getString("email"));
				userModel.setFullName(rs.getString("fullName"));
				userModel.setPassword(rs.getString("password"));
				userModel.setImages(rs.getString("images"));
				userModel.setUserCode(rs.getString("userCode"));
				userModel.setRoleId(rs.getInt("roleId"));
			
				userModel.setStatus(rs.getInt("status"));
				// chua set mot so thuoc tinh khac

				list.add(userModel);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<UserModel> paging(int index) {
		// TODO Auto-generated method stub
		String sql = "Select * from Users order by userName OFFSET ? ROW fetch next 4 rows only";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu sql vào cho phát Prepare
			ps.setInt(1, (index - 1) * 4);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel userModel = new UserModel();
				userModel.setUserId(rs.getInt("userId"));
				userModel.setUserName(rs.getString("userName"));
				userModel.setEmail(rs.getString("email"));
				userModel.setFullName(rs.getString("fullName"));
				userModel.setPassword(rs.getString("password"));
				userModel.setImages(rs.getString("images"));
				userModel.setUserCode(rs.getString("userCode"));
				userModel.setRoleId(rs.getInt("roleId"));
				
				userModel.setStatus(rs.getInt("status"));
				// chua set mot so thuoc tinh khac

				list.add(userModel);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(UserModel userModel) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Users(userName,email,password,images,roleId,status) VALUES (?,?,?,?,?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
//				.setCateId(rs.getInt("categoryId"));
			ps.setString(1, userModel.getUserName());
			ps.setString(2, userModel.getEmail());
//				ps.setString(3, userModel.getFullName());
			ps.setString(3, userModel.getPassword());
			ps.setString(4, userModel.getImages());
			ps.setInt(5, userModel.getRoleId());
			ps.setInt(6, 1);
			ps.executeUpdate();

		} catch (Exception e) {
//				e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		String sql = "update Users set status=? where userName = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setString(2, username);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	@Override
	public void edit(UserModel userModel) {
		// TODO Auto-generated method stub
//			UserModel userModel= new UserModel();
		String sql = "UPDATE Users set fullName = ?,email=?,password=?,images=? where userName=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userModel.getFullName());
			ps.setString(2, userModel.getEmail());
			ps.setString(3, userModel.getPassword());
			ps.setString(4, userModel.getImages());
			ps.setString(5, userModel.getUserName());
			ps.executeUpdate();

		} catch (Exception e) {
//				e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void editindividual(UserModel userModel) {
		// TODO Auto-generated method stub
//			UserModel userModel= new UserModel();
		String sql = "UPDATE Users set fullName = ?,email=?,password=? where userName=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userModel.getFullName());
			ps.setString(2, userModel.getEmail());
			ps.setString(3, userModel.getPassword());
			ps.setString(4, userModel.getUserName());
			ps.executeUpdate();

		} catch (Exception e) {
//				e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void editPassword(UserModel userModel) {
		// TODO Auto-generated method stub
//			UserModel userModel= new UserModel();
		String sql = "UPDATE Users set password=? where userName=?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userModel.getPassword());
			ps.setString(2, userModel.getUserName());
			
			ps.executeUpdate();

		} catch (Exception e) {
//				e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Users";
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
	public boolean insertUser(UserModel account) {
		String sql = "insert into Users(username, email, fullname, password, roleId, status) values(?, ?, ?, ?, ?,?)";
		try
		{
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu sql vào cho phát Prepare
			ps.setString(1, account.getUserName());
			ps.setString(2, account.getEmail());
			ps.setString(3, account.getFullName());
			ps.setString(4, account.getPassword());
			ps.setInt(5, 3);
			ps.setInt(6, 1);
			ps.executeUpdate();
			return true;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;

	}
	
	@Override
	public List<CountByRoleName> countbyRoleNames() {

		List<CountByRoleName> result = new ArrayList<>();
		// TODO Auto-generated method stub
		String sql = "SELECT UserRole.RoleName, COUNT(*) AS CountRoleName\r\n"
				+ "FROM UserRole\r\n"
				+ "LEFT JOIN Users ON Users.roleId = UserRole.roleId\r\n"
				+ "GROUP BY UserRole.RoleName;";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				 String roleName = rSet.getString("RoleName");
	             int countRoleName = rSet.getInt("CountRoleName");
	             CountByRoleName countByRoleName = new CountByRoleName( roleName, countRoleName);
	             result.add(countByRoleName);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
