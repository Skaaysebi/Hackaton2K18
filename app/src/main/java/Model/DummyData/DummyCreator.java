package Model.DummyData;

import java.util.ArrayList;

import Model.Job;
import Model.Room;
import Model.User;

public class DummyCreator {
    public static ArrayList<Job> getSomeJobs(){
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job("", "Sanderring", "Bäume pflanzen", "10.7.18 7:30", "Jemand muss 5 Bäume am Sanderring pflanzen", 300, "Larry Lobster", null));
        return jobs;
    }

    public static ArrayList<Room> getSomeRooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("324567","H1.1",4,"FHWS","Gert","Ein Hörsaal",null,30));
        return rooms;
    }

    public static User getUser() {
        return new User("Heinz", "Ketchup","5679T", "rgfjaofu73",3000, false);
    }
}
