package ua.kardach.antiqueshop.dao.impl;

import org.springframework.stereotype.Repository;

import ua.kardach.antiqueshop.dao.UserDao;
import ua.kardach.antiqueshop.model.User;

@Repository
public class UserSpringJdbcDao extends AbstractSpringJdbcDao implements UserDao {

	@Override
	public User addUser(User user) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User getUserByName(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean updateUser(User user) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean deleteUser(User user) {
		throw new UnsupportedOperationException();
	}

}
