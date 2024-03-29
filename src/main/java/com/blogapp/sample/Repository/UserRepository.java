package com.blogapp.sample.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogapp.sample.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); 
}
