package com.upspapp.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig {
	private final String[] antMatchers = new String[] { "/api/auth/login/**", "/api/auth/admin/login", "/api/file/**",
			"/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", "/login/**",
			"/registration/**", "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**",
			"/api/admin/add/**", "/api/user/add/**", "/api/registrationConfirm/**", "/api/otpVerification/**", "/index",
			"/api/getAll/product", "/js/**", "/otp/**", "/api/getAll/productByQuery/**", "/api/get/product/**",
			"/checkProfile", "/api/user/forgotPassword/", "/api/otpVerification", "/home", "/dashboard",
			"/api/getAll/category", "/location", "/sellingCategory", "/api/**", "/addCategory", "/addSubCategory",
			"/postDetails", "/myAdvertisements", "/images/**", "/listCategory", "/listSubCategory", "/listFeedback",
			"/feedback", "/chat", "/listReport","/api/add/site/feedback" };

	@Resource(name = "userService")
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Bean
	JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationFilter();
	}

	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(antMatchers).permitAll().anyRequest()
				.authenticated().and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
				.passwordEncoder(encoder()).and().build();

	}

}
