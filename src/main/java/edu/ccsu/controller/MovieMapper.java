package edu.ccsu.controller;

import edu.ccsu.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MovieMapper implements RowMapper<Movie> {
   
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
      Movie movie = new Movie();
      movie.setId(rs.getString("id"));
      movie.setTitle(rs.getString("title"));
      movie.setImdbID(rs.getString("imdbID"));
      movie.setImdbPictureURL(rs.getString("imdbPictureURL"));
      movie.setRtAllCriticsNumFresh(rs.getString("rtAllCriticsNumFresh"));
      movie.setRtAllCriticsNumReviews(rs.getString("rtAllCriticsNumReviews"));
      movie.setRtAllCriticsNumRotten(rs.getString("rtAllCriticsNumRotten"));
      movie.setRtAllCriticsRating(rs.getString("rtAllCriticsRating"));
      movie.setRtAllCriticsScore(rs.getString("rtAllCriticsScore"));
      movie.setRtAudienceNumRatings(rs.getString("rtAudienceNumRatings"));
      movie.setRtAudienceScore(rs.getString("rtAudienceScore"));
      movie.setRtAudienceRating(rs.getString("rtAudienceRating"));
      movie.setRtID(rs.getString("rtID"));
      movie.setRtPictureURL(rs.getString("rtPictureURL"));
      movie.setRtTopCriticsNumFresh(rs.getString("rtTopCriticsNumFresh"));
      movie.setRtTopCriticsNumReviews(rs.getString("rtTopCriticsNumReviews"));
      movie.setRtTopCriticsNumRotten(rs.getString("rtTopCriticsNumRotten"));
      movie.setRtTopCriticsRating(rs.getString("rtTopCriticsRating"));
      movie.setRtTopCriticsScore(rs.getString("rtTopCriticsScore"));
      movie.setSpanishTitle(rs.getString("spanishTitle"));
      movie.setYear(rs.getString("year"));
      
      return movie;
   }
}