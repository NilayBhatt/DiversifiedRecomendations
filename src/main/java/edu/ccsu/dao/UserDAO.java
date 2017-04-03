package edu.ccsu.dao;

import edu.ccsu.model.User;

public interface UserDAO {
	boolean validateUser(User user);
	boolean insertNewUser(User user);
}
