package ua.kardach.antiqueshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.OrderLineDao;
import ua.kardach.antiqueshop.dao.impl.row_mapper.OrderLineRowMapper;
import ua.kardach.antiqueshop.model.OrderLine;

/**
 * @author Yura Kardach
 */
@Repository
public class OrderLineSpringJdbcDao implements OrderLineDao{
	
	public final static String SQL_SELECT_ORDER_LINE_BY_ID = "SELECT * FROM order_line WHERE id=?";
	public final static String SQL_SELECT_ORDER_LINE_ALL = "SELECT * FROM order_line";
	public final static String SQL_SELECT_ORDER_LINES_BY_ORDER_ID = "SELECT * FROM order_line WHERE order_id=?";
	public final static String SQL_INSERT_ORDER_LINE_WITH_RETURNED_KEY = "INSERT INTO order_line (order_id, product_id, amount) VALUES (?, ?, ?)";
	public final static String SQL_DELETE_ORDER_LINE_BY_ID = "DELETE FROM order_line WHERE id=?";
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Autowired
	private OrderLineRowMapper mapper;
	
	@Override
	public OrderLine insert(OrderLine orderLine) {
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				final PreparedStatement ps = con.prepareStatement(SQL_INSERT_ORDER_LINE_WITH_RETURNED_KEY, Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, orderLine.getOrderId());
				ps.setLong(2, orderLine.getProduct().getId());
				ps.setInt(3, orderLine.getAmount());
				return ps;
			}
		};
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, keyHolder);
		orderLine.setId(keyHolder.getKey().longValue());
		return orderLine;
	}
	
	@Override
	public OrderLine findById(Long id) {
		return jdbcTemplate.queryForObject(SQL_SELECT_ORDER_LINE_BY_ID, mapper, id);
	}
	
	@Override
	public List<OrderLine> findAll() {
		return jdbcTemplate.query(SQL_SELECT_ORDER_LINE_ALL, mapper);
	}
	
	@Override
	public List<OrderLine> getOrderLinesByOrderId(long orderId) {
		return jdbcTemplate.query(SQL_SELECT_ORDER_LINES_BY_ORDER_ID, mapper, orderId);
	}

	@Override
	public void update(OrderLine orderLine) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(OrderLine orderLine) {
		jdbcTemplate.update(SQL_DELETE_ORDER_LINE_BY_ID, orderLine.getId());
	}

}
