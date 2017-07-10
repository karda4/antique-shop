package ua.kardach.antiqueshop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String redirectToMainPage() {
		return "redirect:/main";
	}

	@RequestMapping("/main")
	public String showMainPage(HttpSession session, Model model) {
		return "main";
	}
}
