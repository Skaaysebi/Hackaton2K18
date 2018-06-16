package Model.APIConnector;

import android.widget.LinearLayout;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIConnector {
    private static String url = "localhost:8080/api";

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

    public static List<User> getAllRooms() {
        url = url + "/rooms";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response == null){
            return null;
        }
        ArrayList<User> foundUsers = null;
        try {
            if(response.body() != null) {
                foundUsers = new Genson().deserialize(response.body().toString(), new GenericType<ArrayList<User>>() {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundUsers;
    }
}
