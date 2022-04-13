package com.example.helper;

import org.springframework.stereotype.Component;

import com.example.entity.User;
/**
 * @author shivi Created on 12-04-2022
 *
 */

@Component
public class UserHelper {

	public boolean validateUser(User user) {
		String regexAlphabet = "[a-zA-Z]+";
		String regexNumber = "^[0-9]*$";
		if (user.getFname().matches(regexAlphabet) && user.getLname().matches(regexAlphabet)
				&& user.getCity().matches(regexAlphabet) && user.getMobNumber().matches(regexNumber))
			return true;
		return false;
	}		
}
