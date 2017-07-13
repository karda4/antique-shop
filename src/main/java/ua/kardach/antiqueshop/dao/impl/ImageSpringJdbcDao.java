package ua.kardach.antiqueshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.ImageDao;
import ua.kardach.antiqueshop.model.Image;

/**
 * @author Yura Kardach
 */
@Repository
public class ImageSpringJdbcDao extends AbstractSpringJdbcDao implements ImageDao{
	
	private final static String SQL_SELECT_IMAGE_BY_ID = "SELECT * FROM image WHERE id=?";

	@Override
	public Image addImage(Image image) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Image getImageById(long id) {
		return getJdbcTemplate().queryForObject(SQL_SELECT_IMAGE_BY_ID, new Object[]{id}, new ImageRowMapper());
	}

	@Override
	public boolean updateImage(Image image) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean deleteImage(Image image) {
		throw new UnsupportedOperationException();
	}

	private static class ImageRowMapper implements RowMapper<Image>{

		@Override
		public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
			Image image = new Image();
			image.setId(rs.getLong("id"));
			image.setPath(rs.getString("path"));
			return image;
		}
		
	}
}
