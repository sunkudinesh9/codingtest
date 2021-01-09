package com.tera.codingtest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tera.codingtest.model.Todo;
import com.tera.codingtest.model.User;
import com.tera.codingtest.repository.TodoRepository;
import com.tera.codingtest.repository.UserRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Todo> getAlltodo(int userId) {
		return todoRepository.findByUserId(userId);
	}

	public String createTodo(Todo todo, int userId) {
		User user = null;
		String message = null;
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
			user.getListOfTodo().add(todo);
			todo.setUser(user);
			userRepository.save(user);
			message = "success!";
		} else {
			message = "User not found";
		}
		return message;
	}
}
