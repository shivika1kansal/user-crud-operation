/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

/**
 * @author shivi Created on 12-04-2022
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
