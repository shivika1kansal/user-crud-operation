/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.entity.User;
import com.example.exception.ValidationException;

/**
 * @author shivi Created on 12-04-2022
 *
 */
public interface UserService {

	User createUser(User user) throws ValidationException;

	boolean isUserExist(int id);

	User updateUser(int id, User user) throws ValidationException;

	User getUser(int id);

	List<User> getUsers();

	void deleteUser(int id);
}
