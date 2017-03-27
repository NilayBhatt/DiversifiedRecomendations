package edu.ccsu.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.ccsu.model.Recommendations;
import edu.ccsu.model.User;

public class RecommendationsMapper implements RowMapper<Recommendations> {
	   
		public Recommendations mapRow(ResultSet rs, int rowNum) throws SQLException {
			Recommendations recommendations = new Recommendations();
			
			recommendations.setMovieId(rs.getString("id"));
			recommendations.setMovieTitle(rs.getString("title"));
			
			return recommendations;
		}


}
