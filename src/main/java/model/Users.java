package model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
public class Users {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
}
