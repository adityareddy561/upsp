package com.upspapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/home")
	public String forHome() {
		return "home";
	}

	@GetMapping("/login")
	public String forLogin() {
		return "login";
	}

	@GetMapping("/myAdvertisements")
	public String forMyAds() {
		return "MyAdvertisement";
	}

	@GetMapping("/location")
	public String location() {
		return "glocation";
	}

	@GetMapping("/registration")
	public String forRegister() {
		return "register";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@GetMapping("/index")
	public String forIndex() {
		return "homepage2";
	}

	@GetMapping("/home/index")
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

	@GetMapping("/listCategory")
	public String listCategory() {
		return "listCategory";
	}

	@GetMapping("/addCategory")
	public String addCategory() {
		return "addCategory";
	}

	@GetMapping("/addSubCategory")
	public String addSubCategory() {
		return "addSubCategory";
	}

	@GetMapping("/listSubCategory")
	public String listSubCategory() {
		return "listSubCategory";
	}

	@GetMapping("/listFeedback")
	public String listFeedback() {
		return "listFeedback";
	}

	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}

	@GetMapping("/chat")
	public String chat() {
		return "chat";
	}

	@GetMapping("/listReport")
	public String listReport() {
		return "listReport";
	}
}
