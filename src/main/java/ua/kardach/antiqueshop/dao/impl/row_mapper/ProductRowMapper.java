package ua.kardach.antiqueshop.dao.impl.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ua.kardach.antiqueshop.model.Category;
import ua.kardach.antiqueshop.model.Image;
import ua.kardach.antiqueshop.model.Product;
import ua.kardach.antiqueshop.service.CategoryService;
import ua.kardach.antiqueshop.service.ImageService;

@Component
public class ProductRowMapper implements RowMapper<Product>{
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long imageId = rs.getLong("image_id");
		Image image = imageService.findById(imageId);
		
		Long categoryId = rs.getLong("category_id");
		Category category = categoryService.findById(categoryId);
		
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
