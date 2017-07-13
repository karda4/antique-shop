package ua.kardach.antiqueshop.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Yura Kardach
 */
public class SessionInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		/*HttpSession session = request.getSession();
		checkUser(session);
		checkOrder(session);*/		
		return true;
	}
	
	
}
