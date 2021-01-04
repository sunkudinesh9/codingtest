package com.tera.codingtest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tera.codingtest.model.Comment;
import com.tera.codingtest.model.Post;
import com.tera.codingtest.model.User;
import com.tera.codingtest.repository.CommentRepository;
import com.tera.codingtest.repository.PostRepository;
import com.tera.codingtest.repository.UserRepository;

@Service
public class CommentService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	public List<Comment> getAllComments(int userId, int postId) {
		return commentRepository.findByUserIdAndPostId(userId, postId);
	}

	public String createComments(Comment comment, int userId, int postId) {
		User user = null;
		String message = null;
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
			Optional<Post> optionalPost = postRepository.findById(postId);
			if (optionalPost.isPresent()) {
				Post post = optionalPost.get();
				comment.setPost(post);
				comment.setUser(user);
				post.getListOfComments().add(comment);
				user.getListOfPosts().add(post);
				userRepository.save(user);
				message = "success!";
			}
		} else {
			message = "User not found";
		}
		return message;
	}
}
