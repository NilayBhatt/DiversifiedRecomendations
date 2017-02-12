package edu.ccsu.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.ccsu.model.User;

public class UserMapper implements RowMapper<User> {
	   
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			
			user.setUserId(rs.getInt("userID"));
			user.setLastName(rs.getString("LastName"));
			user.setUserName(rs.getString("userName"));
			
			return user;
		}

}
