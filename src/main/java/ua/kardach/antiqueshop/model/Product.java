package ua.kardach.antiqueshop.model;

import lombok.Data;

/**
 * @author Yura Kardach
 */
@Data
public class Product {

	private Long id;
	private String name;
	private int price;
	private String description;
	private Category category;
	private Image image;
	
}
