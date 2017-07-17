package ua.kardach.antiqueshop.controllers;

//import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.kardach.antiqueshop.model.Order;
import ua.kardach.antiqueshop.model.User;
import ua.kardach.antiqueshop.service.OrderService;
import ua.kardach.antiqueshop.service.UserService;

/**
 * @author Yura Kardach
 */
@Controller
public class LoginController {
	
	private Logger logger = LogManager.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String name, @RequestParam String password, HttpSession session, Model model) {
		User loginUser = userService.getUserByName(name);
		if (loginUser == null) {
			model.addAttribute("loginError", "There isn't user with name '" + name + "'.");
			logger.info("There isn't user with name '" + name + "'.");
			return "login";
		} else if (!loginUser.getPassword().equals(password)) {
			model.addAttribute("loginError", "Incorrect password.");
			logger.info("Incorrect password=" + password + " for user=" + loginUser);
			return "login";
		}
		logger.info("Logged user=" + loginUser);
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser != null) {
			if (sessionUser.getOrder() != null) {
				Order orderCopy = orderService.cloneOrder(sessionUser.getOrder());
				orderService.deleteOrder(loginUser.getOrder());
				orderService.deleteOrder(sessionUser.getOrder());
				loginUser.setOrder(orderCopy);
				orderService.saveOrder(orderCopy);
			}

		}
		session.setAttribute("user", loginUser);
		return "redirect:/main";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("user=" + session.getAttribute("user") + " is logout.");
		session.removeAttribute("user");
		return "redirect:/main";
	}
}
