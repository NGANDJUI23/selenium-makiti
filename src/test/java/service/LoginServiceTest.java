package service;

import model.UserBuilder;
import model.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Projet d'autonomie
class LoginServiceTest {
    private LoginService loginService;
    private Users trueUsers;
    private Users falseUsers;
    @BeforeEach
    void setUp() {
        trueUsers = UserBuilder.aUser()
                .withUsername("root")
                .withPassword("pass")
                .build();
        falseUsers = UserBuilder.aUser()
                .withUsername("badUser")
                .withPassword("badPasse")
                .build();
        loginService = new LoginService("root", "pass");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void login() {
        assertTrue(loginService.login(trueUsers.getUsername(), trueUsers.getPassword()));
        assertFalse(loginService.login(falseUsers.getUsername(), falseUsers.getPassword()));
    }
}