package com.spstudio.hitchcock.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spstudio.hitchcock.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public Optional<User> findByUsername(String username);
}
