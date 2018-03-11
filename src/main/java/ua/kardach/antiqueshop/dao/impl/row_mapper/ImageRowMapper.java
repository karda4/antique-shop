package ua.kardach.antiqueshop.dao.impl.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ua.kardach.antiqueshop.model.Image;

@Component
public class ImageRowMapper implements RowMapper<Image>{

	@Override
	public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
		Image image = new Image();
		image.setId(rs.getLong("id"));
		image.setPath(rs.getString("path"));
		return image;
	}
	
}
