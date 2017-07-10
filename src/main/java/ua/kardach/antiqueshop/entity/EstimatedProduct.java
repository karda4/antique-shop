package ua.kardach.antiqueshop.entity;

public class EstimatedProduct {
	
	private int id;
	private String name;
	private int price;
	private String description;
	private EstimatedCategory category;
	
	public EstimatedProduct() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EstimatedCategory getCategory() {
		return category;
	}

	public void setCategory(EstimatedCategory category) {
		this.category = category;
	}
}
