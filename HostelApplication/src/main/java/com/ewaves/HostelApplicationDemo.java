package com.ewaves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.ewaves.config.CORSSecurityFilter;
import com.ewaves.config.CustomUserDetailsService;
import com.ewaves.config.SecurityConfiguration;

@SpringBootApplication
@EnableWebSecurity
@EnableScheduling
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ewaves.entities", "com.ewaves", "com.ewaves.config" }, basePackageClasses = {
		CORSSecurityFilter.class, SecurityConfiguration.class, CustomUserDetailsService.class })
public class HostelApplicationDemo {

	public static void main(String[] args) {
		SpringApplication.run(HostelApplicationDemo.class, args);
	}
}
