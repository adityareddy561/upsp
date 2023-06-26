package com.upspapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/login")
	public String forLogin() {
		return "login";
	}

	@GetMapping("/registration")
	public String forRegister() {
		return "register";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@GetMapping("/homepage")
	public String forHome() {
		return "homepage";
	}

	@GetMapping("/index")
	public String forIndex() {
		return "homepage2";
	}

	@GetMapping("/homepage/index")
	public String forHome(@RequestParam Long userId, ModelMap model) {
		System.out.println(userId);
		model.addAttribute("userId", userId);
		return "index";
	}

	@GetMapping("/otp")
	public String forOtpVerifcation() {
		return "Otp";
	}

	@GetMapping("/checkProfile")
	public String forProfile(ModelMap model) {
		return "profile";
	}

	@GetMapping("/sellingCategory")
	public String forSellingCategory() {
		return "sellCategory";
	}

	@GetMapping("/post")
	public String forAddPost() {
		return "addPost";
	}

	@GetMapping("/passwordCheck")
	public String forPasswords() {
		return "passwordUpdation";
	}

	@GetMapping("postDetails")
	public String forPostDetails() {
		return "itemDetails";
	}

	@GetMapping("/ads")
	public String checkAds() {
		return "post";
	}

	@GetMapping("/dynamic")
	public String dyn() {
		return "dynamicTable";
	}
}
