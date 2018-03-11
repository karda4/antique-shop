package ua.kardach.antiqueshop.dao.impl.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ua.kardach.antiqueshop.dao.impl.CategorySpringJdbcDao;
import ua.kardach.antiqueshop.dao.impl.ImageSpringJdbcDao;
import ua.kardach.antiqueshop.model.Category;
import ua.kardach.antiqueshop.model.Image;
import ua.kardach.antiqueshop.model.Product;

@Component
public class ProductRowMapper implements RowMapper<Product>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long imageId = rs.getLong("image_id");
		Image image = jdbcTemplate.queryForObject(ImageSpringJdbcDao.SQL_SELECT_IMAGE_BY_ID, new Object[] { imageId }, new ImageRowMapper());
		
		Long categoryId = rs.getLong("category_id");
		Category category = jdbcTemplate.queryForObject(CategorySpringJdbcDao.SQL_SELECT_CATEGORY_BY_ID, new Object[] { categoryId }, new CategoryRowMapper());
		
		Product product = new Product();
		product.setId(rs.getLong("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setImage(image);
		product.setCategory(category);
		product.setPrice(rs.getInt("price"));
		return product;
	}
	
}
