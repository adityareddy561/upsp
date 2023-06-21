package com.upspapp.utility;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.upspapp.modal.User;
import com.upspapp.repository.UserRepository;

public class Utility {

	public static String generateRandomPassword(int len) {
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;

		Random rndm_method = new Random();

		String password = "";

		for (int i = 0; i < len; i++) {

			char ch = values.charAt(rndm_method.nextInt(values.length()));
			password += ch;
		}
		return password;
	}

	public static User getSessionUser(UserRepository userRepository) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUsername = authentication.getName();
		return userRepository.findByMobileNumberOrEmail(currentUsername, currentUsername);
	}

	public static Date getFormatedDateFromDate(Date date, int hourOfDay, int minute) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.AM_PM, 0);
			calendar.set(Calendar.HOUR, hourOfDay);
			calendar.set(Calendar.MINUTE, minute);
			calendar.set(Calendar.SECOND, 0);
			return calendar.getTime();
		} catch (Exception e) {
			return null;
		}
	}

}
