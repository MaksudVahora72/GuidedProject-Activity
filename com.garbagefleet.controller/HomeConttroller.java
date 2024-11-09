package com.garbagefleet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.garbagefleet.model.UserMaster;

@Controller
public class HomeConttroller {

	@GetMapping("/")
	public String landing(Model model) {
		model.addAttribute("user", new UserMaster());
		return "index";
	}
}
