package com.upspapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.upspapp.properties.FileStorageProperties;

@SpringBootApplication
@ComponentScan(basePackages = "com.upspapp")
@EnableConfigurationProperties({ FileStorageProperties.class })
public class UPSPApplication {

	public static void main(String[] args) {
		SpringApplication.run(UPSPApplication.class, args);
	}

}
