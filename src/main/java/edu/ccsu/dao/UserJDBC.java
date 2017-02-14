package edu.ccsu.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ccsu.controller.UserMapper;
import edu.ccsu.model.Rating;
import edu.ccsu.model.User;

public class UserJDBC implements UserDAO {

	private DataSource dataSource;
	protected JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean validateUser(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append("Select * from users where username = '");
		sb.append(user.getUserName());
		sb.append("' and userPassword = '");
		sb.append(user.getPassword());
		sb.append("'");

		try {
			List<User> users = jdbcTemplateObject.query(sb.toString(), new UserMapper());
			if (users.size() > 0)
				
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean insertRating(Rating rating) {
		
		String sql = "Insert INTO userMovieRating (userName, movieID, rating) Values (?,?,?)";

		try {
			jdbcTemplateObject.update(sql, new Object[] { rating.getUserName(),
					rating.getMovieID(),Integer.parseInt(rating.getUserRating())});				
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
