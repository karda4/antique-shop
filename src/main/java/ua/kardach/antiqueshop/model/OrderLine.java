package ua.kardach.antiqueshop.model;

import lombok.Data;

/**
 * @author Yura Kardach
 */
@Data
public class OrderLine {

	private Long id;
	private Long orderId;
	private Product product;
	private int amount;

}
