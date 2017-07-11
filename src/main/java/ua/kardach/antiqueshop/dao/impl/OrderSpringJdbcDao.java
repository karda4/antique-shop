package ua.kardach.antiqueshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.OrderDao;
import ua.kardach.antiqueshop.model.Order;

@Repository
public class OrderSpringJdbcDao extends AbstractSpringJdbcDao implements OrderDao{

	private final static String SQL_SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id=?";
	private final static String SQL_INSERT_ORDER_WITH_RETURNED_KEY = "INSERT INTO orders(user_id) VALUES(?)";
		
	@Override
	public boolean addOrder(Order order) {
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				final PreparedStatement ps = con.prepareStatement(SQL_INSERT_ORDER_WITH_RETURNED_KEY, Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, order.getUser().getId());
				return ps;
			}
		};
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(psc, keyHolder);
		order.setId(keyHolder.getKey().longValue());
		return true;
		
		/*Map<String, Object> param = new HashMap<String, Object>();
		param.put("user_id", order.getUserId());
		Number id = getSimpleJdbcInsert().executeAndReturnKey(param);
		order.setId(id.longValue());
		return true;*/
		/*int rows = getJdbcTemplate().update(SQL_INSERT_ORDER, new Object[] { order.getUserId()});
		return rows == 1;*/
	}

	@Override
	public Order getOrderById(long id) {
		return getJdbcTemplate().queryForObject(SQL_SELECT_ORDER_BY_ID, new Object[]{id}, new OrderRowMapper());
	}

	@Override
	public boolean updateOrder(Order order) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean deleteOrder(Order order) {
		throw new UnsupportedOperationException();
	}

	private static class OrderRowMapper implements RowMapper<Order>{

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = new Order();
			order.setId(rs.getLong("id"));
			order.setUserId(rs.getLong("user_id"));
			return order;
		}
		
	}
}
