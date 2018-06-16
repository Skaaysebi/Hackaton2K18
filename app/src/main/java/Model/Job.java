package Model;

public class Job {
    private int jobId;
    private String location;
    private String name;
    private String dateTime;
    private String description;
    private int reward;
    private String responsiblePerson;
    private User worker;

    public Job() {
    }

    public Job(int jobId, String location, String name, String dateTime, String description, int reward, String responsiblePerson, User worker) {
        this.jobId = jobId;
        this.location = location;
        this.name = name;
        this.dateTime = dateTime;
        this.description = description;
        this.reward = reward;
        this.responsiblePerson = responsiblePerson;
        this.worker = worker;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public User getWorker() {
        return worker;
    }

    public void setWorker(User worker) {
        this.worker = worker;
    }
}
