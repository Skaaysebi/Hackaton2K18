package Model.APIConnector;

import android.widget.LinearLayout;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Event;
import Model.Job;
import Model.Room;
import Model.Room;
import Model.User;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIConnector {
    private static String url = "http://10.0.2.2:8080/api";

    public static User getUserFromDB(User user) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().post(new FormBody.Builder().build())
                .url(url + "/register")
                .addHeader("username", user.getUserName())
                .addHeader("password", user.getUserPassword())
                .addHeader("cardid", user.getCardId())
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
                foundUser = new Genson().deserialize(response.body().string(), User.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundUser;
    }

    public static List<Room> getAllRooms() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url + "/rooms").get().build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response == null){
            return null;
        }
        ArrayList<Room> foundUsers = null;
        try {
            if(response.body() != null) {
                foundUsers = new Genson().deserialize(response.body().string(), new GenericType<ArrayList<Room>>() {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundUsers;
    }

    public static List<Event> getAllEvents() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url + "/events").get().build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response == null){
            return null;
        }
        ArrayList<Event> foundEvents = null;
        try {
            if(response.body() != null) {
                foundEvents = new Genson().deserialize(response.body().toString(), new GenericType<ArrayList<Event>>() {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundEvents;
    }

    public static List<Job> getAllJobs() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url + "/jobs").get().build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response == null){
            return null;
        }
        ArrayList<Job> foundJobs = null;
        try {
            if(response.body() != null) {
                foundJobs = new Genson().deserialize(response.body().toString(), new GenericType<ArrayList<Job>>() {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundJobs;
    }

    public static List<Job> getAllJobsForUser(String uId){
        List<Job> jobs = getAllJobs();
        List<Job> outputJob = new ArrayList<>();
        for(Job job : jobs){
            if(job.getWorker().getUserId().equals(uId))
                outputJob.add(job);
        }
        return outputJob;
    }
}
