package ua.kardach.antiqueshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.UserDao;
import ua.kardach.antiqueshop.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User addUser(User user){
		return userDao.addUser(user);
	}

	public User getUserByName(String name){
		return userDao.getUserByName(name);
	}

	public boolean updateUser(User user){
		return userDao.updateUser(user);
	}

	public boolean deleteUser(User user){
		return userDao.deleteUser(user);
	}
}
