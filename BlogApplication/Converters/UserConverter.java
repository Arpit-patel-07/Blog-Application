package com.example.BlogApplication.Converters;

import com.example.BlogApplication.Dtos.UserRequest;
import com.example.BlogApplication.Dtos.UserResponse;
import com.example.BlogApplication.Entities.User;

public class UserConverter {

    public static User userRequestToUser(UserRequest userRequest){

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setAbout(userRequest.getAbout());
        user.setPassword(userRequest.getPassword());
        return  user;
    }

    public static UserResponse userToUserResponse(User user){

        UserResponse userResponse = new UserResponse();
        userResponse.setAbout(user.getAbout());
        userResponse.setEmail(user.getEmail());
        userResponse.setName(user.getName());
        return  userResponse;
    }
}
