package model;

public class UserBuilder {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }
    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }
    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
    public UserBuilder withRole(String role) {
        this.role = role;
        return this;
    }
    public Users build() {
        return new Users(username, password, email, role);
    }
}
