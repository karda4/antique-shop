package ua.kardach.antiqueshop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.RoleDao;
import ua.kardach.antiqueshop.dao.impl.row_mapper.RoleRowMapper;
import ua.kardach.antiqueshop.model.Role;

@Repository
public class RoleSpringJdbcDao implements RoleDao {

	public final static String SQL_SELECT_ALL_ROLES_BY_USER_ID = "SELECT * FROM role_user LEFT JOIN role ON role_user.role_id=role.id WHERE user_id=?";

	public final static String ROLE_ADMIN = "admin";
	public final static String ROLE_MODERATOR = "moderator";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private RoleRowMapper mapper;

	@Override
	public List<Role> getAllByUserId(long userId) {
		return (List<Role>) jdbcTemplate.query(SQL_SELECT_ALL_ROLES_BY_USER_ID, mapper, userId);
	}

}
