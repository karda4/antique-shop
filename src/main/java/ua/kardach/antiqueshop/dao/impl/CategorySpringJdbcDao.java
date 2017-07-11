package ua.kardach.antiqueshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.CategoryDao;
import ua.kardach.antiqueshop.model.Category;

@Repository
public class CategorySpringJdbcDao extends AbstractSpringJdbcDao implements CategoryDao{
	
	private final static String SQL_SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";

	@Override
	public Category addCategory(Category category) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Category getCategoryById(long id) {
		return getJdbcTemplate().queryForObject(SQL_SELECT_CATEGORY_BY_ID, new Object[]{id}, new CategoryRowMapper());
	}

	@Override
	public boolean updateCategory(Category category) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean deleteCategory(Category category) {
		throw new UnsupportedOperationException();
	}

	private static class CategoryRowMapper implements RowMapper<Category>{

		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			return category;
		}
		
	}
}
