package com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Security.Config;

import com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Entity.User;
import com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Security.POJOAUTH.AuthRequest;
import com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Security.POJOAUTH.AuthResponse;
import com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Utility.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthApi {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTTokenUtil jwtTokenUtil;
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest authRequest){
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
            User user = (User) authenticate.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(user);
            AuthResponse authResponse = new AuthResponse(user.getEmail(), accessToken);
            return ResponseEntity.ok().body(authResponse);
        }catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
