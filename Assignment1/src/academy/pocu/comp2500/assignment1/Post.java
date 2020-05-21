package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Post {
    private final UUID postId;
    private final String authorId;
    private String title;
    private String body;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private HashSet<HashMap<ReactionType, User>> reactions;

    public Post(String title, String body, User user) {
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
            this.modifiedDateTime = OffsetDateTime.now();
        }
    }

    public void modifyPostBody(String body, User user) {
        if (this.authorId.equals(user.getUserId())) {
            this.body = body;
            this.modifiedDateTime = OffsetDateTime.now();
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }

    public void addReaction(ReactionType type, User user) {
        var a = new HashMap<ReactionType, User>().put(type, user);
        //this.reactions.add(a);
    }


}
