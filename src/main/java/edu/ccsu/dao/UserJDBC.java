package edu.ccsu.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ccsu.helper.UserMapper;
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

	public boolean insertNewUser(User user) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Users (userName, LastName, userPassword) VALUES (?, ?, ?)");

		try {
			int users = jdbcTemplateObject.update(sql.toString(),
					new Object[] { user.getUserName(), user.getLastName(), user.getPassword() });
			if (users > 0)

				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
