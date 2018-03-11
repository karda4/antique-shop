package ua.kardach.antiqueshop.dao.impl.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ua.kardach.antiqueshop.dao.impl.ProductSpringJdbcDao;
import ua.kardach.antiqueshop.model.OrderLine;
import ua.kardach.antiqueshop.model.Product;

@Component
public class OrderLineRowMapper implements RowMapper<OrderLine>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long productId = rs.getLong("product_id");
		Product product = jdbcTemplate.queryForObject(ProductSpringJdbcDao.SQL_SELECT_PRODUCT_BY_ID, new Object[] { productId }, new ProductRowMapper());
		
		OrderLine orderLine = new OrderLine();
		orderLine.setId(rs.getLong("id"));
		orderLine.setOrderId(rs.getLong("order_id"));
		orderLine.setProduct(product);
		orderLine.setAmount(rs.getInt("amount"));
		return orderLine;
	}
	
}
