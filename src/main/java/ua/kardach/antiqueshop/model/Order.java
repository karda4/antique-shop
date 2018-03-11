package ua.kardach.antiqueshop.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yura Kardach
 */
@Data
@NoArgsConstructor
public class Order {

	private long id;
	private long userId;
	
	private List<OrderLine> orderLines;
	private int totalPrice;

	public Order(Order order) {
		setId(order.getId());
		setUserId(order.getUserId());
		setOrderLines(order.getOrderLines());
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

	private void calculateTotalPrice() {
		int totalPrice = 0;
		if (getOrderLines() != null) {
			for (OrderLine orderLine : getOrderLines()) {
				totalPrice += orderLine.getProduct().getPrice();
			}
		}
		setTotalPrice(totalPrice);
	}

}
