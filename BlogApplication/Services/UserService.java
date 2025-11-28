package com.example.BlogApplication.Services;

import com.example.BlogApplication.Converters.UserConverter;
import com.example.BlogApplication.Dtos.UserResponse;
import com.example.BlogApplication.Entities.User;
import com.example.BlogApplication.Repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

        @Autowired
        private UserRepositorie userRepositorie;

        public UserResponse createUser(User user){
            User savedUser = userRepositorie.save(user);
            return UserConverter.userToUserResponse(savedUser);
        }

        public UserResponse updateUser(User user, Integer userId){
            User existingUser = userRepositorie.findUserById(userId);
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setName(user.getName());
            existingUser.setAbout(user.getAbout());
            User savedUser = userRepositorie.save(existingUser);
            return UserConverter.userToUserResponse(savedUser);
        }

        public  boolean deleteUser(Integer userId){
            userRepositorie.deleteById(userId);
            return true;
        }

        public UserResponse getUser(Integer userId){
            User user = userRepositorie.findUserById(userId);
            return UserConverter.userToUserResponse(user);
        }
}
