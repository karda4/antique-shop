package ua.kardach.antiqueshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Estimation {

	@RequestMapping("/estimation")
	public String show(){
		return "estimation";
	}
}
