package com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Security.POJOAUTH;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Data
public class AuthRequest {
    @NotNull
    @Email
    @Length(min = 5,max = 50)
    private String email;
    @NotNull
    @Length(min = 6,max = 25)
    private String password;
}
