package com.echobeat.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    private String SECRET_KEY = "dfndsovnfdnbfdibfdinbfd"; // Change this to a secure key

    // Generate JWT token
    public String generateToken(long user_id) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, Long.toString(user_id));
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Validate token
    public Boolean validateToken(String token, long user_id) {
        final long extractedUserId = extractUserId(token);
        return Long.toString(extractedUserId).equals(Long.toString(user_id));
    }

    public long AuthenticateToken(HttpServletRequest request){
        String token = request.getHeader("Authorization").substring(7);
        return extractUserId(token);
    }

    private long extractUserId(String token) {
        try {
            return Long.parseLong(extractAllClaims(token).getSubject());
        } catch (Exception e) {
            return -1;
        }
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
