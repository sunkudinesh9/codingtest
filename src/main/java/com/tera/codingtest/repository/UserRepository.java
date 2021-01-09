package com.tera.codingtest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tera.codingtest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String username);

	Optional<User> findById(int userId);
	
}
