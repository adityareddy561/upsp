package com.upspapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// send responce
		config.enableSimpleBroker("/topic", "/user");
		// get request
		config.setApplicationDestinationPrefixes("/app");
		// for user

	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
		registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:8181").withSockJS();
	}
}