package service;

//Projet d'autonomie
public class LoginService {
    private String username;
    private String password;
    public LoginService(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean login(String username, String password) {
        return (username.equals(this.username) && password.equals(this.password));
    }
}
