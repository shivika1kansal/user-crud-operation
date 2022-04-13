/**
 * 
 */
package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.UserNotFoundException;

/**
 * @author shivi Created on 12-04-2022
 *
 */

@ControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exceptionHandler(UserNotFoundException exception) {
		return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
	}
}