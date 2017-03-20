package edu.ccsu.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.ccsu.model.Rating;

public class RatingsMapper implements RowMapper<Rating> {
	   
		public Rating mapRow(ResultSet rs, int rowNum) throws SQLException {
			Rating userRating = new Rating();
			
			userRating.setUserName(rs.getString("userID"));
			userRating.setMovieID(rs.getString("movieID"));
			userRating.setUserRating(rs.getString("rating"));
			
			return userRating;
		}

}
