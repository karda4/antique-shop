package ua.kardach.antiqueshop.dao.impl.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ua.kardach.antiqueshop.model.User;

@Component
public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		/*String roleName = rs.getString("role_name");
		user.setAdmin(roleName != null ? roleName.equals("admin") : false);*/
		//user.setAdmin(rs.getInt("admin") == 1);
		user.setRegistered(rs.getInt("registered") == 1);
		return user;
	}
	
}
