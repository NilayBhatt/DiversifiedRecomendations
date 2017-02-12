package edu.ccsu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ccsu.model.User;

public class UserJDBC implements UserDAO {

	private DataSource dataSource;
	protected JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean validateUser(User user) {
		String query = "Select count(1) from users where username = ? and password = ?";
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			resultSet = pstmt.executeQuery();
			if (resultSet.next())
				return (resultSet.getInt(1) > 0);
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
