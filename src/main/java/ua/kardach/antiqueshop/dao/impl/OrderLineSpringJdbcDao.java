package ua.kardach.antiqueshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.OrderLineDao;
import ua.kardach.antiqueshop.model.OrderLine;

@Repository
public class OrderLineSpringJdbcDao extends AbstractSpringJdbcDao implements OrderLineDao{
	
	private final static String SQL_SELECT_ORDER_LINE_BY_ID = "SELECT * FROM order_line WHERE id=?";
	private final static String SQL_SELECT_ORDER_LINES_BY_ORDER_ID = "SELECT * FROM order_line WHERE order_id=?";
	private final static String SQL_INSERT_ORDER_LINE_WITH_RETURNED_KEY = "INSERT INTO order_line (order_id, product_id, amount) VALUES (?, ?, ?)";
	private final static String SQL_DELETE_ORDER_LINE_BY_ID = "DELETE FROM order_line WHERE id=?";
	
	
	@Override
	public boolean addOrderLine(OrderLine orderLine) {
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				final PreparedStatement ps = con.prepareStatement(SQL_INSERT_ORDER_LINE_WITH_RETURNED_KEY, Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, orderLine.getOrder().getId());
				ps.setLong(2, orderLine.getProduct().getId());
				ps.setInt(3, orderLine.getAmount());
				return ps;
			}
		};
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(psc, keyHolder);
		orderLine.setId(keyHolder.getKey().longValue());
		return true;
	}
	
	@Override
	public OrderLine getOrderLineById(long id) {
		return getJdbcTemplate().queryForObject(SQL_SELECT_ORDER_LINE_BY_ID, new Object[]{id}, new OrderLineRowMapper());
	}
	
	@Override
	public List<OrderLine> getOrderLinesByOrderId(long orderId) {
		return getJdbcTemplate().query(SQL_SELECT_ORDER_LINES_BY_ORDER_ID, new Object[]{orderId}, new OrderLineRowMapper());
	}

	@Override
	public boolean updateOrderLine(OrderLine orderLine) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean deleteOrderLine(OrderLine orderLine) {
		int rows = getJdbcTemplate().update(SQL_DELETE_ORDER_LINE_BY_ID, new Object[]{orderLine.getId()});
		return rows == 1;
	}

	private static class OrderLineRowMapper implements RowMapper<OrderLine>{

		@Override
		public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderLine orderLine = new OrderLine();
			orderLine.setId(rs.getLong("id"));
			orderLine.setOrderId(rs.getLong("order_id"));
			orderLine.setProductId(rs.getLong("product_id"));
			orderLine.setAmount(rs.getInt("amount"));
			return orderLine;
		}
		
	}
}
