package ua.kardach.antiqueshop.dao;

import ua.kardach.antiqueshop.model.User;

/**
 * @author Yura Kardach
 */
public interface UserDao extends AbstractDao<User, Long>{

	// read
	public User findByName(String name);

}
