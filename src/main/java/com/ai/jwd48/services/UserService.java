package com.ai.jwd48.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.jwd48.model.User;
import com.ai.jwd48.repo.UserRepo;

@Service("userDao")
public class UserService {

	@Autowired
	private UserRepo repo;

	public boolean checkUserNameAndPassword(String username, String password) {

		User user = repo.findByUserName(username);

		if (null == user) {
			return false;
		} else {
			if (password.equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}
