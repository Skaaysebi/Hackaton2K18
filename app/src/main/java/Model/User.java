package Model;

public class User {
    private String username;
    private String password;
    private String cardId;
    private boolean isAdmin;
    private int amount;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String cardId, boolean isAdmin, int amount) {
        this.username = username;
        this.password = password;
        this.cardId = cardId;
        this.isAdmin = isAdmin;
        this.amount = amount;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
