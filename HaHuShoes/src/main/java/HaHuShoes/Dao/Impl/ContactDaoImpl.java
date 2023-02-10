package HaHuShoes.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iContactDao;
import HaHuShoes.Model.ContactModel;

public class ContactDaoImpl extends ConnectionDB implements iContactDao{

	
	@Override
	public void insert(ContactModel contact) {
		
		String sql="INSERT INTO [Contact](name, email, subject, message) VALUES (?,?,?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setString(3, contact.getSubject());
			ps.setString(4, contact.getMessage());
			ps.executeUpdate();
			
		} catch (Exception e) {
//			e.printStackTrace();
		System.out.println(e.getMessage());
	}
	}
}
