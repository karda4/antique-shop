package ua.kardach.antiqueshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.UserDao;
import ua.kardach.antiqueshop.dao.impl.row_mapper.UserRowMapper;
import ua.kardach.antiqueshop.model.User;

/**
 * @author Yura Kardach
 */
@Repository
public class UserSpringJdbcDao implements UserDao {
	
	public final static String SQL_SELECT_USER_BY_NAME = "SELECT * FROM users WHERE name=?";
	public final static String SQL_SELECT_USER_BY_ID = "SELECT * FROM users WHERE id=?";
	public final static String SQL_SELECT_USER_ALL = "SELECT * FROM users";
	
	public final static String SQL_INSERT_USER_WITH_RETURNED_KEY = "INSERT INTO users (name) VALUES (?)";
	public final static String SQL_UPDATE_USER_BY_ID = "UPDATE users SET name=?, password=?, admin=?, registered=? WHERE id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserRowMapper mapper;
	
	@Override
	public User insert(User user) {
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				final PreparedStatement ps = con.prepareStatement(SQL_INSERT_USER_WITH_RETURNED_KEY, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				return ps;
			}
		};
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		Long id = keyHolder.getKey().longValue();
		return findById(id);
	}

	@Override
	public User findByName(String name) {
		List<User> userList = jdbcTemplate.query(SQL_SELECT_USER_BY_NAME, new Object[]{name}, new UserRowMapper());
		if(userList.isEmpty()){
			return null;
		}
		else if(userList.size() == 1){
			return userList.get(0);
		}
		throw new RuntimeException("Finded more then one user with name '" + name + "' in database!");
	}
	
	@Override
	public List<User> findAll() {
		return jdbcTemplate.query(SQL_SELECT_USER_ALL, mapper);
	}

	@Override
	public User findById(Long id) {
		return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID, mapper, id);
	}

	@Override
	public void update(User user) {
		Object[] param = {
				user.getName(),
				user.getPassword(),
				user.isAdmin() ? 1 : 0,
				user.isRegistered() ? 1 : 0,
				user.getId()
		};
		jdbcTemplate.update(SQL_UPDATE_USER_BY_ID, param);
	}

	@Override
	public void delete(User user) {
		throw new UnsupportedOperationException();
	}

}	
