package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.exception.ValidationException;
import com.example.service.UserService;

/**
 * @author shivi Created on 12-04-2022
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * This handler will create the user
	 * 
	 * @param user
	 * @throws ValidationException 
	 */

	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		try {
			user = userService.createUser(user);
			return new ResponseEntity<>("User is created with Id =" + user.getId(), HttpStatus.CREATED);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("User Information is not correct",HttpStatus.NOT_ACCEPTABLE);
	}

	/**
	 * This handler will update the user of given id
	 * 
	 * @param id
	 * @param user
	 * @throws ValidationException 
	 */

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") int id, @RequestBody User user)
			throws UserNotFoundException, ValidationException {
		boolean isUserExist = userService.isUserExist(id);
		if (isUserExist) {
			userService.updateUser(id, user);
			return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}
	}

	/**
	 * This handler will get the specific user
	 * 
	 * @param id
	 */

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") int id) throws UserNotFoundException {
		boolean isUserExist = userService.isUserExist(id);
		if (isUserExist) {
			User user = userService.getUser(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}
	}

	/**
	 * This handler will get all the user
	 */

	@GetMapping("/get")
	public ResponseEntity<Object> getUsers() {
		List<User> userList = userService.getUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	/**
	 * This handler will delete the user of given id
	 * 
	 * @param id
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id) throws UserNotFoundException {
		boolean isUserExist = userService.isUserExist(id);
		if (isUserExist) {
			userService.deleteUser(id);
			return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}
	}

}
