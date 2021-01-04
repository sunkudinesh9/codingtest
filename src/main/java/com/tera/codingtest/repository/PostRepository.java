package com.tera.codingtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tera.codingtest.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	@Query(value = "select * from post where user_id =?1", nativeQuery = true)
	List<Post> findByUserId(int userId);
}
