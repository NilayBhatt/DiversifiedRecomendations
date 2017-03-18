package edu.ccsu.dao;

import edu.ccsu.model.Rating;
import edu.ccsu.model.User;

public interface UserDAO {
	boolean validateUser(User user);
	boolean insertRating(Rating rating);
	boolean insertNewUser(User user);
}
