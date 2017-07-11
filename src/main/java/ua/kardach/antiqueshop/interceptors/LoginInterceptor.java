package ua.kardach.antiqueshop.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ua.kardach.antiqueshop.model.Order;
import ua.kardach.antiqueshop.model.User;
import ua.kardach.antiqueshop.service.OrderService;
import ua.kardach.antiqueshop.service.UserService;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		checkUser(session);
		checkOrder(session);		
		return true;
	}
	
	private void checkUser(HttpSession session){
		User user = (User) session.getAttribute("user");
		if (user == null) {
			user = userService.addUser();
			session.setAttribute("user", user);
		}
	}
	
	private void checkOrder(HttpSession session){
		User user = (User) session.getAttribute("user");
		Order order = (Order) session.getAttribute("order");
		if(order == null){
			order = orderService.addOrder(user);
			if(order == null){
				throw new RuntimeException("Cann't create an order!");
			}
			session.setAttribute("order", order);
		}
	}
}
