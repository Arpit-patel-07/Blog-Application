package com.example.BlogApplication.Security;

import com.example.BlogApplication.Entities.User;
import com.example.BlogApplication.Repositories.UserRepositorie;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class jwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private final UserRepositorie userRepositorie;

    @Autowired
    private final Authutil authutil;

    public jwtAuthFilter(UserRepositorie userRepositorie, Authutil authutil) {
        this.userRepositorie = userRepositorie;
        this.authutil = authutil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestToken = request.getHeader("Authorization");

        if (requestToken == null || !requestToken.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = requestToken.split("Bearer")[1];
        String userName = authutil.getUserNameFromToken(token);

        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){

            User user = userRepositorie.findByEmail(userName);
            UsernamePasswordAuthenticationToken token1 = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token1);
        }
    }
}
