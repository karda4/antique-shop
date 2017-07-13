package ua.kardach.antiqueshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.ProductDao;
import ua.kardach.antiqueshop.model.Product;

/**
 * @author Yura Kardach
 */
@Repository
public class ProductSpringJdbcDao extends AbstractSpringJdbcDao implements ProductDao{
	
	private final static String SQL_SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id=?";
	private final static String SQL_SELECT_ALL_PRODUCTS = "SELECT * FROM product";

	@Override
	public Product addProduct(Product product) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Product getProductById(long id) {
		return getJdbcTemplate().queryForObject(SQL_SELECT_PRODUCT_BY_ID, new Object[]{id}, new ProductRowMapper());
	}
	
	@Override
	public List<Product> getAllProducts() {
		return getJdbcTemplate().query(SQL_SELECT_ALL_PRODUCTS, new ProductRowMapper());
	}

	@Override
	public boolean updateProduct(Product product) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean deleteProduct(Product product) {
		throw new UnsupportedOperationException();
	}	
	
	private static class ProductRowMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getLong("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setImageId(rs.getLong("image_id"));
			product.setCategoryId(rs.getLong("category_id"));
			product.setPrice(rs.getInt("price"));
			return product;
		}
		
	}
}
