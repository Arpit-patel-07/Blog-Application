package com.example.BlogApplication.Repositories;

import com.example.BlogApplication.Dtos.UserResponse;
import com.example.BlogApplication.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositorie extends JpaRepository<User,Integer> {

    public User findUserById(int userId);
    public User findByEmail(String email);

}
