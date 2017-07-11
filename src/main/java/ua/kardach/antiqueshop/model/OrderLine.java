package ua.kardach.antiqueshop.model;

public class OrderLine {

	private long id;
	private long orderId;
	private Order order;
	private long productId;
	private Product product;
	private int amount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		setOrderId(order.getId());
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		setProductId(product.getId());
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", order=" + order + ", product=" + product + ", amount=" + amount + "]";
	}
	
	
}
