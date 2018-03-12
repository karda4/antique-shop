package ua.kardach.antiqueshop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import ua.kardach.antiqueshop.dao.ProductDao;
import ua.kardach.antiqueshop.dao.impl.row_mapper.ProductRowMapper;
import ua.kardach.antiqueshop.model.Product;

/**
 * @author Yura Kardach
 */
@Slf4j
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
		if(id == null) {
			return null;
		}
		List<Product> result = jdbcTemplate.query(SQL_SELECT_PRODUCT_BY_ID, mapper, id);
		if(result.isEmpty()) {
			return null;
		}
		else if(result.size() == 1){
			return result.get(0);
		}
		else {
			String error = "More than one product with id=" + id;
			log.error(error);
			throw new RuntimeException(error);
		}
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
