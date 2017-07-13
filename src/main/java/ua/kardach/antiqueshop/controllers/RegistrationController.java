package ua.kardach.antiqueshop.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.kardach.antiqueshop.model.User;
import ua.kardach.antiqueshop.service.UserService;

/**
 * @author Yura Kardach
 */
@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistrationForm(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("userForm", user);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String doRegistration(@Valid @ModelAttribute("userForm") User userForm, BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "registration";
		}
		
		//check unique nick
		if(!userService.isUserNickUnique(userForm.getName())){
			model.addAttribute("registrationError", "Already exist user with nick " + userForm.getName());
			return "registration";
		}
				
		if(userService.registrateUser(userForm)){
			session.setAttribute("user", userForm);
		}
		return "redirect:/main";
	}
}
