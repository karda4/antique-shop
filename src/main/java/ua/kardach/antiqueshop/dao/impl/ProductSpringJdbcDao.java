package ua.kardach.antiqueshop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.ProductDao;
import ua.kardach.antiqueshop.dao.impl.row_mapper.ProductRowMapper;
import ua.kardach.antiqueshop.model.Product;

/**
 * @author Yura Kardach
 */
@Repository
public class ProductSpringJdbcDao implements ProductDao{
	
	public final static String SQL_SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id=?";
	public final static String SQL_SELECT_ALL_PRODUCTS = "SELECT * FROM product";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ProductRowMapper mapper;

	@Override
	public Product insert(Product product) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Product findById(Long id) {
		return jdbcTemplate.queryForObject(SQL_SELECT_PRODUCT_BY_ID, mapper, id);
	}
	
	@Override
	public List<Product> findAll() {
		return jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, mapper);
	}

	@Override
	public void update(Product product) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Product product) {
		throw new UnsupportedOperationException();
	}	
	
}
