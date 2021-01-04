package com.tera.codingtest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tera.codingtest.model.Comment;
import com.tera.codingtest.model.LoginDetails;
import com.tera.codingtest.model.Post;
import com.tera.codingtest.model.Todo;
import com.tera.codingtest.model.User;
import com.tera.codingtest.security.JwtUtils;
import com.tera.codingtest.service.CommentService;
import com.tera.codingtest.service.PostService;
import com.tera.codingtest.service.TodoService;
import com.tera.codingtest.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@Autowired
	private TodoService todoService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/auth/register/", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@RequestMapping(value = "/auth/login/", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody LoginDetails loginDetails) {
		// Validate userName/password
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDetails.getUsername(), loginDetails.getPassword()));

		// generate token
		String token = jwtUtils.generateToken(loginDetails.getUsername());
		return new ResponseEntity<String>(token, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{userid}/posts/", method = RequestMethod.POST)
	public String createPost(@RequestBody Post post, @PathVariable(value = "userid") int userId) {
		return postService.createPost(post, userId);
	}

	@RequestMapping(value = "/user/{userid}/posts/", method = RequestMethod.GET)
	public List<Post> getpost(@PathVariable(value = "userid") int userId) {
		return postService.getAllPost(userId);
	}

	@RequestMapping(value = "/user/{userid}/todos/", method = RequestMethod.POST)
	public String createTodo(@RequestBody Todo todo, @PathVariable(value = "userid") int userId) {
		return todoService.createTodo(todo, userId);
	}

	@RequestMapping(value = "/user/{userid}/todos/", method = RequestMethod.GET)
	public List<Todo> getTodo(@PathVariable(value = "userid") int userId) {
		return todoService.getAlltodo(userId);
	}

	@RequestMapping(value = "/user/{userid}/posts/{postid}/comments/", method = RequestMethod.POST)
	public String createComment(@RequestBody Comment comment, @PathVariable(value = "userid") int userId,
			@PathVariable(value = "postid") int postId) {
		return commentService.createComments(comment, userId, postId);
	}

	@RequestMapping(value = "/user/{userid}/posts/{postid}/comments/", method = RequestMethod.GET)
	public List<Comment> getAllComment(@PathVariable(value = "userid") int userId,
			@PathVariable(value = "postid") int postId) {
		return commentService.getAllComments(userId, postId);
	}

}
