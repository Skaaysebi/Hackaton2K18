package Model;

public class Room {
    private String title;
    private String location;
    private String id;
    private int size;
    private String responsiblePerson;
    private String description;
    private User user;
    private int price;

    public Room(String title, String location, String id, int size, String responsiblePerson, String description, User user, int price) {
        this.title = title;
        this.location = location;
        this.id = id;
        this.size = size;
        this.responsiblePerson = responsiblePerson;
        this.description = description;
        this.user = user;
        this.price = price;
    }

    public Room(String title, String location, String id, int size, String responsiblePerson, String description, User user) {
        this.title = title;
        this.location = location;
        this.id = id;
        this.size = size;
        this.responsiblePerson = responsiblePerson;
        this.description = description;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
