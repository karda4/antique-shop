package ua.kardach.antiqueshop.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private long id;
	private long userId;
	private User user;
	private List<OrderLine> orderLines;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		setUserId(user.getId());
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public void addOrderLine(OrderLine orderLine){
		List<OrderLine> orderLines = getOrderLines();
		if(orderLines == null){
			orderLines = new ArrayList<OrderLine>();
			setOrderLines(orderLines);
		}
		orderLines.add(orderLine);
	}
	
	public boolean removeOrderLine(OrderLine orderLine){
		List<OrderLine> orderLines = getOrderLines();
		if(orderLines == null){
			return false;
		}
		return orderLines.remove(orderLine);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", orderLines=" + orderLines + "]";
	}
	
	
}
