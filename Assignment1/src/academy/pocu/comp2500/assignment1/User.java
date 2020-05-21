package academy.pocu.comp2500.assignment1;

public class User {
    private final String userId;
    private final String userName;
    private final String nickName;
    private final String displayName;
    private String emailAddress;

    public User(String userId, String userName, String nickName) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.displayName = nickName;
    }

    public User(String userId, String userName, String nickName, String emailAddress) {
        this(userId, userName, nickName);
        this.emailAddress = emailAddress;
    }

    public String getUserId() {
        return this.userId;
    }
    public String getUserName() {
        return this.userName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
