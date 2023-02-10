package HaHuShoes.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import HaHuShoes.Connection.ConnectionDB;
import HaHuShoes.Dao.iCommentDao;
import HaHuShoes.Model.CommentModel;

public class CommentDaoImpl extends ConnectionDB implements iCommentDao{

	@Override
	public void insert(CommentModel comment) {
		
		String sql="INSERT INTO [Comment](review, name, email) VALUES (?,?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, comment.getReview());
			ps.setString(2, comment.getName());
			ps.setString(3, comment.getEmail());
			ps.executeUpdate();
			
		} catch (Exception e) {
//			e.printStackTrace();
		System.out.println(e.getMessage());
	}
	}
	
	@Override
	public List<CommentModel> findTop3() {
		List<CommentModel> comments = new ArrayList<CommentModel>();
		String sql = "SELECT TOP 3 * FROM Comment";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CommentModel comment = new CommentModel();
				comment.setId(rs.getInt("id"));
				comment.setReview(rs.getString("review"));
				comment.setName(rs.getString("name"));
				comment.setEmail(rs.getString("email"));
				comments.add(comment);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return comments;
	}
	
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Comment";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
}
