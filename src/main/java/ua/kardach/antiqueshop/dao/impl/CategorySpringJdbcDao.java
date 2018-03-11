package ua.kardach.antiqueshop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.CategoryDao;
import ua.kardach.antiqueshop.dao.impl.row_mapper.CategoryRowMapper;
import ua.kardach.antiqueshop.model.Category;

/**
 * @author Yura Kardach
 */
@Repository
public class CategorySpringJdbcDao implements CategoryDao{
	
	public final static String SQL_SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";
	public final static String SQL_SELECT_ALL = "SELECT * FROM category";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CategoryRowMapper mapper;

	@Override
	public Category insert(Category category) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Category findById(Long id) {
		return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY_BY_ID, mapper, id);
	}
	
	@Override
	public List<Category> findAll() {
		return jdbcTemplate.query(SQL_SELECT_ALL, mapper);
	}

	@Override
	public void update(Category category) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Category category) {
		throw new UnsupportedOperationException();
	}

}
