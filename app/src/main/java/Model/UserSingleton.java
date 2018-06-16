package Model;

public class UserSingleton {
    private static User instance;

    private UserSingleton(){

    }

    public static void initInstance(String userString){

    }

    public User getInstance(){
        return instance;
    }
}