package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Post {
    private UUID postId;
    private String authorId;
    private String title;
    private String body;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    public Post(User user, String title, String body) {
        this.postId = UUID.randomUUID();
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
        this.authorId = user.getUserId();
        this.title = title;
        this.body = body;
    }

    public void modifyPostTitle(String title, User user) {
        if (this.authorId.equals(user.getUserId())) {
            this.title = title;
        }
    }

    public void modifyPostBody(String body, User user) {
        if (this.authorId.equals(user.getUserId())) {
            this.body = body;
        }
    }

}
