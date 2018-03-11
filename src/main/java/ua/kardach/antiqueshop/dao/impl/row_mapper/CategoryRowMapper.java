package ua.kardach.antiqueshop.dao.impl.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ua.kardach.antiqueshop.model.Category;

@Component
public class CategoryRowMapper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		category.setId(rs.getLong("id"));
		category.setName(rs.getString("name"));
		return category;
	}
	
}