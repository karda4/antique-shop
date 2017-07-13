package ua.kardach.antiqueshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.UserDao;
import ua.kardach.antiqueshop.model.User;

/**
 * @author Yura Kardach
 */
@Repository
public class UserSpringJdbcDao extends AbstractSpringJdbcDao implements UserDao {
	
	private final static String SQL_SELECT_USER_BY_NAME = "SELECT * FROM user WHERE name=?";
	private final static String SQL_INSERT_USER_WITH_RETURNED_KEY = "INSERT INTO user (name) VALUES (?)";
	private final static String SQL_UPDATE_USER_BY_ID = "UPDATE user SET name=?, password=?, admin=?, registered=? WHERE id=?";
	
	@Override
	public boolean addUser(User user) {
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				final PreparedStatement ps = con.prepareStatement(SQL_INSERT_USER_WITH_RETURNED_KEY, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				return ps;
			}
		};
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(psc, keyHolder);
		user.setId(keyHolder.getKey().longValue());
		return true;
	}

	@Override
	public User getUserByName(String name) {
		List<User> userList = (List<User>) getJdbcTemplate().query(SQL_SELECT_USER_BY_NAME, new Object[]{name}, new UserRowMapper());
		if(userList.isEmpty()){
			return null;
		}
		else if(userList.size() == 1){
			return userList.get(0);
		}
		throw new RuntimeException("Finded more then one user with name '" + name + "' in database!");
	}

	@Override
	public boolean updateUser(User user) {
		Object[] param = {
				user.getName(),
				user.getPassword(),
				user.isAdmin() ? 1 : 0,
				user.isRegistered() ? 1 : 0,
				user.getId()
		};
		int rows = getJdbcTemplate().update(SQL_UPDATE_USER_BY_ID, param);
		return rows == 1;
	}

	@Override
	public boolean deleteUser(User user) {
		throw new UnsupportedOperationException();
	}

	private static class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setAdmin(rs.getInt("admin") == 1);
			user.setRegistered(rs.getInt("registered") == 1);
			return user;
		}
		
	}
}	
