package com.programming.learning.springblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programming.learning.springblog.model.Users;

@Repository	
public interface UserRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByUserName(String userName);
}
