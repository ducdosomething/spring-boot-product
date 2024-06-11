package com.example.springbootproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootproduct.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String name);
}
