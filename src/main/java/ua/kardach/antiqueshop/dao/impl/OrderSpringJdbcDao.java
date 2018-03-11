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

import ua.kardach.antiqueshop.dao.OrderDao;
import ua.kardach.antiqueshop.dao.impl.row_mapper.OrderRowMapper;
import ua.kardach.antiqueshop.model.Order;

/**
 * @author Yura Kardach
 */
@Repository
public class OrderSpringJdbcDao implements OrderDao{

	public final static String SQL_SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id=?";
	public final static String SQL_SELECT_ORDER_ALL = "SELECT * FROM orders";
	public final static String SQL_SELECT_ORDER_BY_USER_ID = "SELECT * FROM orders WHERE user_id=?";
	public final static String SQL_INSERT_ORDER_WITH_RETURNED_KEY = "INSERT INTO orders(user_id) VALUES(?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private OrderRowMapper mapper;
		
	@Override
	public Order insert(Order order) {
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				final PreparedStatement ps = con.prepareStatement(SQL_INSERT_ORDER_WITH_RETURNED_KEY, Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, order.getUserId());
				return ps;
			}
		};
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		int rows = jdbcTemplate.update(psc, keyHolder);
		if(rows == 1){
			Long id = keyHolder.getKey().longValue();
			return findById(id);
		}
		throw new RuntimeException("Cann't insert Order=" + order);
	}

	@Override
	public Order findById(Long id) {
		return jdbcTemplate.queryForObject(SQL_SELECT_ORDER_BY_ID, mapper, id);
	}
	
	@Override
	public List<Order> findAll() {
		return jdbcTemplate.query(SQL_SELECT_ORDER_ALL, mapper);
	}
	
	@Override
	public Order getOrderByUserId(long userId) {
		List<Order> list = jdbcTemplate.query(SQL_SELECT_ORDER_BY_USER_ID, new Object[]{userId}, mapper);
		if(list.isEmpty()){
			return null;
		}
		else if(list.size() == 1){
			return list.get(0);
		}
		throw new RuntimeException("Finded more then one order with userId '" + userId + "' in database!");
	}

	@Override
	public void update(Order order) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Order order) {
		throw new UnsupportedOperationException();
	}

}
