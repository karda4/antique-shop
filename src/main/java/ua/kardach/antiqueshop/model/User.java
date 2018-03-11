package ua.kardach.antiqueshop.model;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * @author Yura Kardach
 */
@Data
public class User {

	private long id;
	@NotNull
	@Size(min=4, max=12)
	private String name;
	@NotNull
	@Size(min=3)
	private String password;
	private boolean registered;
	private boolean admin;
	private Set<Role> roles;
	
	//
	private Order order;
	
	public boolean isAdmin() {
		return roles.contains(Role.ADMIN);
	}

	public void setOrder(Order order) {
		this.order = order;
		if(this.order != null){
			this.order.setUserId(getId());
		}
	}
			
}
