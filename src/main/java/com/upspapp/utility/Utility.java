package com.upspapp.utility;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.upspapp.modal.User;
import com.upspapp.repository.UserRepository;

public class Utility {

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
