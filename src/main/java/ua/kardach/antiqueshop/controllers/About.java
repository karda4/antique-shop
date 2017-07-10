package ua.kardach.antiqueshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class About {

	@RequestMapping("about")
	public String show(){
		return "about";
	}
}
