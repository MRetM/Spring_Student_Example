package com.ai.jwd48.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.ai.jwd48.model.User;

@Component
public class UserRepo extends DBContext {

	public User findByUserName(String userName) {
		User user = null;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("Select * from user where username = ? ");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPosition(rs.getString("position"));
				user.setPhoneNumber(rs.getString("phone_number"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return user;
	}

}
