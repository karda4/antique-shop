package ua.kardach.antiqueshop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import ua.kardach.antiqueshop.model.Order;
import ua.kardach.antiqueshop.model.User;
import ua.kardach.antiqueshop.service.OrderService;
import ua.kardach.antiqueshop.service.UserService;

/**
 * @author Yura Kardach
 */
@Slf4j
@Controller
public class LoginController {
	
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
			log.info("There isn't user with name '" + name + "'.");
			return "login";
		} else if (!loginUser.getPassword().equals(password)) {
			model.addAttribute("loginError", "Incorrect password.");
			log.info("Incorrect password=" + password + " for user=" + loginUser);
			return "login";
		}
		log.info("Logged user=" + loginUser);
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser != null) {
			if (sessionUser.getOrder() != null) {
				Order orderCopy = orderService.cloneOrder(sessionUser.getOrder());
				orderService.delete(loginUser.getOrder());
				orderService.delete(sessionUser.getOrder());
				loginUser.setOrder(orderCopy);
				orderService.insert(orderCopy);
			}

		}
		session.setAttribute("user", loginUser);
		return "redirect:/main";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		log.info("user=" + session.getAttribute("user") + " is logout.");
		session.removeAttribute("user");
		return "redirect:/main";
	}
}
