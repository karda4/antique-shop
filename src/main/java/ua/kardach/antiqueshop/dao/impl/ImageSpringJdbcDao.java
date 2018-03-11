package ua.kardach.antiqueshop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.ImageDao;
import ua.kardach.antiqueshop.dao.impl.row_mapper.ImageRowMapper;
import ua.kardach.antiqueshop.model.Image;

/**
 * @author Yura Kardach
 */
@Repository
public class ImageSpringJdbcDao implements ImageDao{
	
	public final static String SQL_SELECT_IMAGE_BY_ID = "SELECT * FROM image WHERE id=?";
	public final static String SQL_SELECT_IMAGE_ALL = "SELECT * FROM image";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ImageRowMapper mapper;

	@Override
	public Image insert(Image image) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Image findById(Long id) {
		return jdbcTemplate.queryForObject(SQL_SELECT_IMAGE_BY_ID, mapper, id);
	}
	
	@Override
	public List<Image> findAll() {
		return jdbcTemplate.query(SQL_SELECT_IMAGE_ALL, mapper);
	}

	@Override
	public void update(Image image) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Image image) {
		throw new UnsupportedOperationException();
	}

}
