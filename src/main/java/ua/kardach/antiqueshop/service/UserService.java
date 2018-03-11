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
	
	public User insert(User user){
		return userDao.insert(user);
	}
	
	public User addUser() {
		User user = createUser();
		return insert(user);
	}
	
	private User createUser(){
		return new User();
	}

	public User getUserByName(String name){
		User user = userDao.findByName(name);
		Order order = orderService.getOrderByUserId(user.getId());
		user.setOrder(order);
		user.setRoles(roleService.getAllByUserId(user.getId()));
		return user;
	}
	
	public boolean registrateUser(User user){
		user.setRegistered(true);
		update(user);
		return true;
	}

	public void update(User user){
		userDao.update(user);
	}

	public void delete(User user){
		userDao.delete(user);
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
