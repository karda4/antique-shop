package ua.kardach.antiqueshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.RoleDao;
import ua.kardach.antiqueshop.model.Role;

@Repository
public class RoleSpringJdbcDao extends AbstractSpringJdbcDao implements RoleDao {

	private final static String SQL_SELECT_ALL_ROLES_BY_USER_ID = "SELECT * FROM role_user LEFT JOIN role ON role_user.role_id=role.id WHERE user_id=?";

	private final static String ROLE_ADMIN = "admin";
	private final static String ROLE_MODERATOR = "moderator";

	@Override
	public List<Role> getAllByUserId(long userId) {
		return (List<Role>) getJdbcTemplate().query(SQL_SELECT_ALL_ROLES_BY_USER_ID, new Object[] { userId }, new RoleRowMapper());
	}

	private static class RoleRowMapper implements RowMapper<Role> {

		@Override
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			String roleName = rs.getString("name");
			if (roleName != null) {
				if (roleName.equals(ROLE_ADMIN)) {
					return Role.ADMIN;
				} else if (roleName.equals(ROLE_MODERATOR)) {
					return Role.MODERATOR;
				}
			}
			return null;
		}

	}
}
