package Model;

public class UserSingleton {
    private static User instance;

    private UserSingleton(){

    }

    public static void initInstance(User user){
        instance = user;
    }

    public static User getInstance(){
        return instance;
    }
}
