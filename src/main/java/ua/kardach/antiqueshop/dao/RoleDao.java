package ua.kardach.antiqueshop.dao;

import java.util.List;

import ua.kardach.antiqueshop.model.Role;

public interface RoleDao {

	public List<Role> getAllByUserId(long userId);
}
