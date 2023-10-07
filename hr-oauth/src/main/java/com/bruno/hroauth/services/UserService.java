package com.bruno.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.hroauth.entities.User;
import com.bruno.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger Logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired 
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			Logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		Logger.info("Email found: " + email);
		return user;
	}

}
