package model;

public class UserFactory {
    public static Users createAdmin(){
        return UserBuilder.aUser()
                .withRole("ADMIN")
                .build();
    }
    public static Users createUser(){
        return UserBuilder.aUser()
                .withRole("USER")
                .build();
    }
}
