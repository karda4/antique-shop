package ua.kardach.antiqueshop.model;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Yura Kardach
 */
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public boolean isAdmin() {
		return roles.contains(Role.ADMIN);
	}

	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		if(this.order != null){
			this.order.setUserId(getId());
		}
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", registered=" + registered + ", admin=" + admin + "]";
	}
			
}
