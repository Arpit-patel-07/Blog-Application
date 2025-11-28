package com.example.BlogApplication.Security;

import com.example.BlogApplication.Dtos.LoginRequest;
import com.example.BlogApplication.Dtos.LoginResponse;
import com.example.BlogApplication.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Authutil authutil;

    public LoginResponse login(LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));

        User user = (User) authentication.getPrincipal();

        String token = authutil.generateAccesToken(user);

        return new LoginResponse(user.getId(),token);
    }
}
