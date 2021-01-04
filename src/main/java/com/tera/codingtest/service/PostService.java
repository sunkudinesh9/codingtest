package com.tera.codingtest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tera.codingtest.model.Post;
import com.tera.codingtest.model.User;
import com.tera.codingtest.repository.PostRepository;
import com.tera.codingtest.repository.UserRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Post> getAllPost(int userId) {
		return postRepository.findByUserId(userId);
	}

	public String createPost(Post post, int userId) {
		User user = null;
		String message = null;
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
			user.getListOfPosts().add(post);
			post.setUser(user);
			userRepository.save(user);
			message = "success!";
		} else {
			message = "User not found";
		}
		return message;
	}
}
