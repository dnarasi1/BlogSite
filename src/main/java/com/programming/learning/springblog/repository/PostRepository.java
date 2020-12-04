package com.programming.learning.springblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programming.learning.springblog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
}
