package com.axis.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.model.User;
import com.axis.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public User addUser(User user) {
		User user1=userRepository.save(user);
		return user1;
	}
	@Override
	public List<User> getAllUsers() {
		List<User> user2=userRepository.findAll();
		return user2;
	}

}
