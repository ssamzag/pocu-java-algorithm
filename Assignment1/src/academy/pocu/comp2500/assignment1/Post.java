package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
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
    private HashSet<String> tagList;

    public Post(String title, String body, User user) {
        this.postId = UUID.randomUUID();
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
        this.authorId = user.getUserId();
        this.title = title;
        this.body = body;
    }

    public void updateTitle(String title, User user) {
        if (this.authorId.equals(user.getUserId())) {
            this.title = title;
            this.modifiedDateTime = OffsetDateTime.now();
        }
    }

    public void updateBody(String body, User user) {
        if (this.authorId.equals(user.getUserId())) {
            this.body = body;
            this.modifiedDateTime = OffsetDateTime.now();
        }
    }

    public void addTag(String tag) {
        if (this.tagList == null) {
            this.tagList = new HashSet<String>();
        }
        tagList.add(tag);
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

    public String getPostList() {
        return "";
    }

    public void addReaction(ReactionType type, User user) {
        if (this.reactions == null) {
            this.reactions = new HashSet<HashMap<ReactionType, User>>();
        }
        var a = new HashMap<ReactionType, User>().put(type, user);
     //   this.reactions.add(a);
    }
    public void removeReaction() {

    }
    public void addComment() {

    }

    public void getCommentList() {

    }

    public void getSubcommentList() {

    }


}
