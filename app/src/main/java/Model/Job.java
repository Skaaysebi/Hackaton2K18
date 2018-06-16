package Model;

public class Job {
    private int jobId;
    private String location;
    private String name;
    private String date;
    private String description;
    private int reward;
    private String responsiblePerson;
    private String workerId;

    public Job(int jobId, String location, String name, String date, String description, int reward, String responsiblePerson) {
        this.jobId = jobId;
        this.location = location;
        this.name = name;
        this.date = date;
        this.description = description;
        this.reward = reward;
        this.responsiblePerson = responsiblePerson;
    }

    public Job(int jobId, String location, String name, String date, String description, int reward, String responsiblePerson, String workerId) {
        this.jobId = jobId;
        this.location = location;
        this.name = name;
        this.date = date;
        this.description = description;
        this.reward = reward;
        this.responsiblePerson = responsiblePerson;
        this.workerId = workerId;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
}
