package com.example.BlogApplication.Controllers;

import com.example.BlogApplication.Converters.UserConverter;
import com.example.BlogApplication.Dtos.UserRequest;
import com.example.BlogApplication.Dtos.UserResponse;
import com.example.BlogApplication.Entities.User;
import com.example.BlogApplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping("/create")
        public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
            User user = UserConverter.userRequestToUser(userRequest);
            UserResponse userResponse = userService.createUser(user);
            return  new ResponseEntity<>(userResponse, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        public ResponseEntity<UserResponse>  updateUser(@RequestBody UserRequest userRequest , @RequestParam("Id") Integer userId){
            User user = UserConverter.userRequestToUser(userRequest);
            UserResponse userResponse = userService.updateUser(user,userId);
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        }

        @DeleteMapping("/delete")
        public ResponseEntity<Boolean> deleteUser(@RequestParam("userId") Integer userId){
            boolean res = userService.deleteUser(userId);
            return  new ResponseEntity<>(res,HttpStatus.OK);
        }

        @GetMapping("/get")
        public ResponseEntity<UserResponse> getUser(@RequestParam("userId") Integer userId){
            UserResponse userResponse = userService.getUser(userId);
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        }
}
