package ua.kardach.antiqueshop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yura Kardach
 */
public class Order {

	private long id;
	private long userId;
	
	private List<OrderLine> orderLines;
	private int totalPrice;

	public Order() {

	}

	public Order(Order order) {
		setId(order.getId());
		setUserId(order.getUserId());
		setOrderLines(order.getOrderLines());
	}

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

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
		calculateTotalPrice();
	}

	public void addOrderLine(OrderLine orderLine) {
		List<OrderLine> orderLines = getOrderLines();
		if (orderLines == null) {
			orderLines = new ArrayList<OrderLine>();
		}
		orderLines.add(orderLine);
		setOrderLines(orderLines);
	}

	public boolean removeOrderLine(OrderLine orderLine) {
		List<OrderLine> orderLines = getOrderLines();
		if (orderLines == null) {
			return false;
		}
		if (orderLines.remove(orderLine)) {
			setOrderLines(orderLines);
			return true;
		}
		return false;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	private void calculateTotalPrice() {
		int totalPrice = 0;
		if (getOrderLines() != null) {
			for (OrderLine orderLine : getOrderLines()) {
				totalPrice += orderLine.getProduct().getPrice();
			}
		}
		setTotalPrice(totalPrice);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderLines=" + orderLines + ", totalPrice=" + totalPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
