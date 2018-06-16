package Model.APIConnector;

import com.owlike.genson.Genson;

import java.io.IOException;

import Model.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIConnector {
    private static String url = "";

    public static User getUserFromDB(User user) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("username", user.getUsername())
                .addHeader("password", user.getPassword())
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response == null){
            return null;
        }
        User foundUser = null;
        try {
            if(response.body() != null) {
                foundUser = new Genson().deserialize(response.body().toString(), User.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundUser;
    }
}
