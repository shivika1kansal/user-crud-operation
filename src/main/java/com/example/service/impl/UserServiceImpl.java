/**
 * 
 */
package com.example.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.exception.ValidationException;
import com.example.helper.UserHelper;
import com.example.repository.UserRepository;
import com.example.service.UserService;

/**
 * @author shivi Created on 12-04-2022
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserHelper userHelper;

	/**
	 * This method will create the user
	 * 
	 * @param user
	 * @throws ValidationException 
	 */

	@Override
	public User createUser(User user) throws ValidationException {
		if(userHelper.validateUser(user)) {
		return userRepo.save(user);}
		else {
			throw new ValidationException("User Information is not valid");
		}
	}

	/**
	 * This handler will check the user exists or not
	 * 
	 * @param id
	 */

	@Override
	public boolean isUserExist(int id) {
		if (userRepo.findById(id).isPresent()) {
			return true;
		}
		return false;
	}

	/**
	 * This handler will update the user of given id
	 * 
	 * @param id
	 * @param user
	 * @throws ValidationException 
	 */

	@Override
	public User updateUser(int id, User user) throws ValidationException {
		if(userHelper.validateUser(user)) {
		User existingUser = userRepo.findById(id).orElse(null);
		existingUser = modelMapper.map(user, User.class);
		existingUser.setId(id);
		userRepo.save(existingUser);
		return existingUser;}
		else {
			throw new ValidationException("User Information is not valid");
		}
	}

	/**
	 * This handler will get the specific user
	 * 
	 * @param id
	 */
	@Override
	public User getUser(int id) {
		return userRepo.findById(id).orElse(null);
	}

	/**
	 * This handler will get all the user
	 */
	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	/**
	 * This handler will delete the user of given id
	 * 
	 * @param id
	 */
	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}

}
