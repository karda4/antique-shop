package ua.kardach.antiqueshop.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ua.kardach.antiqueshop.model.User;
import ua.kardach.antiqueshop.service.UserService;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			/*response.sendRedirect(request.getContextPath() + "/login");
			return false;*/
			user = new User();
			session.setAttribute("user", user);
		}
		return true;
	}	
}
