package edu.ccsu.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ccsu.helper.RatingsMapper;
import edu.ccsu.model.Rating;

public class RatingsJDBC {

	private DataSource dataSource;
	protected JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public boolean insertRating(Rating rating) {

		String sql = "Insert INTO userMovieRating (userName, movieID, rating) Values (?,?,?)";

		try {
			jdbcTemplateObject.update(sql, new Object[] { rating.getUserName(), rating.getMovieID(),
					Double.parseDouble(rating.getUserRating()) });
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<Rating> getCurrentUserRatings(String userID) {
		String sql = "SELECT userName, movieID, rating from userMovieRating WHERE userName = '";

		sql += userID + "'";
		List<Rating> userRatings = jdbcTemplateObject.query(sql, new RatingsMapper());

		return userRatings;

	}

}
