package ua.kardach.antiqueshop.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.UserDao;
import ua.kardach.antiqueshop.model.Order;
import ua.kardach.antiqueshop.model.User;

/**
 * @author Yura Kardach
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private OrderService orderService;
	@Autowired
	private RoleService roleService;
	
	public boolean saveUser(User user){
		return userDao.addUser(user);
	}
	
	public User addUser() {
		User user = createUser();
		if(saveUser(user)){
			return user;
		}
		return null;
	}
	
	private User createUser(){
		return new User();
	}

	public User getUserByName(String name){
		User user = userDao.getUserByName(name);
		Order order = orderService.getOrderByUserId(user.getId());
		user.setOrder(order);
		user.setRoles(roleService.getAllByUserId(user.getId()));
		return user;
	}
	
	public boolean registrateUser(User user){
		user.setRegistered(true);
		if(updateUser(user)){
			return true;
		}
		user.setRegistered(false);
		return false;
	}

	public boolean updateUser(User user){
		return userDao.updateUser(user);
	}

	public boolean deleteUser(User user){
		return userDao.deleteUser(user);
	}
	
	public boolean isUserNickUnique(String nick){
		User user = this.getUserByName(nick);
		return user == null;
	}
	
	public boolean isUserRegistered(User user){
		return user.isRegistered();
	}
	
	public void createIfNotExistSessionUser(HttpSession session){
		User user = (User) session.getAttribute("user");
		if (user == null) {
			user = addUser();
			session.setAttribute("user", user);
		}
		if(user.getOrder() == null){
			orderService.addOrder(user);
		}
	}
}
