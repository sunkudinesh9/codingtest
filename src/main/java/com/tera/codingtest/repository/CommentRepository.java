package com.tera.codingtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tera.codingtest.model.Comment;
import com.tera.codingtest.model.Post;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	@Query(value = "select * from comments where user_id =?1 and post_id=?2", nativeQuery = true)
	List<Comment> findByUserIdAndPostId(int userId, int postId);
}
