package com.SpringSecurityJWTRESTAPI.JWTRESTAPI.UserTest;


import com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Entity.User;
import com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void createUSerTest() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordEncoded = bCryptPasswordEncoder.encode("mahmoud2022");

        User user = new User("mahmoud@gmail", passwordEncoded);
        User savedUser = userRepository.save(user);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);

    }
}
