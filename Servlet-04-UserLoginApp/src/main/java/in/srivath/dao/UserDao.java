package in.srivath.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import in.srivath.dto.User;
import in.srivath.util.ConnectionFactory;

public class UserDao {
	private static final String insertSql = "INSERT INTO APPUSER VALUES(?,?,?,?,?,?)";
	private static final String getSql = "SELECT * FROM APPUSER WHERE email=?";

	public boolean saveUser(User user) {
		int count = 0;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, user.getFname());
			pstmt.setString(2, user.getLname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPwd());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getRole());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count > 0;
	}

	public User getUser(String email) {
		User user = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(getSql);
			pstmt.setString(1, email);
			ResultSet rSet = pstmt.executeQuery();
			user = new User();
			if (rSet.next()) {
				user.setFname(rSet.getString("fname"));
				user.setLname(rSet.getString("lname"));
				user.setEmail(rSet.getString("email"));
				user.setPwd(rSet.getString("pwd"));
				user.setGender(rSet.getString("gender"));
				user.setRole(rSet.getString("urole"));
			}	
			rSet.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
