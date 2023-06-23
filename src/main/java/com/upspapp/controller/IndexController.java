package com.upspapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/homepage")
	public String forHome() {
		return "home";
	}

	@GetMapping("/otp")
	public String forOtpVerifcation(@RequestParam Long userId, ModelMap model) {
		System.out.println(userId);
		model.addAttribute("userId", userId);
		return "Otp";
	}

	@GetMapping("/checkProfile")
	public String forProfile() {
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
