package ua.kardach.antiqueshop.dao.impl.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ua.kardach.antiqueshop.dao.impl.RoleSpringJdbcDao;
import ua.kardach.antiqueshop.model.Role;

@Component
public class RoleRowMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		String roleName = rs.getString("name");
		if (roleName != null) {
			if (roleName.equals(RoleSpringJdbcDao.ROLE_ADMIN)) {
				return Role.ADMIN;
			} else if (roleName.equals(RoleSpringJdbcDao.ROLE_MODERATOR)) {
				return Role.MODERATOR;
			}
		}
		return null;
	}

}
