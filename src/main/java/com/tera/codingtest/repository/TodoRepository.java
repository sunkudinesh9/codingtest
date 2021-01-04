package com.tera.codingtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tera.codingtest.model.Post;
import com.tera.codingtest.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	@Query(value = "select * from todo where user_id =?1", nativeQuery = true)
	List<Todo> findByUserId(int userId);
}
