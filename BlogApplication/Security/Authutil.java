package com.example.BlogApplication.Security;

import com.example.BlogApplication.Entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import static io.jsonwebtoken.Jwts.*;

@Component
public class Authutil {

    @Value("${jwt.secretkey}")  // inject from application.properties
    private String jwtSecretKey;

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccesToken(User user){

        return builder()
                .setSubject(user.getUsername())
                .claim("userId",user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+100*60*10))
                .signWith(getSecretKey())
                .compact();
    }

    public String getUserNameFromToken(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
