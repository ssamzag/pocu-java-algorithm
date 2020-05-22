package academy.pocu.comp2500.assignment1;

public class User {
    private final String userId;
    private final String nickname;
    private String emailAddress;

    public User(String userId, String nickname) {
        this.userId = userId;
        this.nickname = nickname;
    }

    public User(String userId, String nickname, String emailAddress) {
        this(userId, nickname);
        this.emailAddress = emailAddress;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }
}
