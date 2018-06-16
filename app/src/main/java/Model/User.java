package Model;

public class User {
    private String userId;
    private String userName;
    private String userPassword;
    private String cardId;
    private int credit;
    private boolean isSuperuser;

    public User () {

    }

    public User(String userName, String userPassword, String cardId) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.cardId = cardId;
    }

    public User(String userId, String userName, String userPassword, String cardId, int credit, boolean isSuperuser) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.credit = credit;
        this.isSuperuser = isSuperuser;
        this.cardId = cardId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isSuperuser() {
        return isSuperuser;
    }

    public void setSuperuser(boolean superuser) {
        isSuperuser = superuser;
    }
}
