package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Comment {
    private UUID commentId;
    private User user;
    private String content;
    private ArrayList<Comment> subcomments;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private HashMap<User, String> votes;

    public Comment(String content, User user) {
        if (user == null) {
            return;
        }
        this.commentId = UUID.randomUUID();
        this.content = content;
        this.user = user;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
    }

    public void updateContent(String content, User user) {
        if (this.user.equals(user)) {
            this.content = content;
            this.modifiedDateTime = OffsetDateTime.now();
        }
    }

    public String getContent() {
        return this.content;
    }

    public void setUpVote(User user) {
        vote("U", user);
    }

    public void setDownVote(User user) {
        vote("D", user);
    }

    private void vote(String voteType, User user) {
        if (this.votes.get(user) == voteType) {
            votes.put(user, null);
        } else {
            votes.put(user, voteType);
        }
    }

    public void addSubcomment(Comment comment) {
        if (this.subcomments == null) {
            this.subcomments = new ArrayList<Comment>();
        }
        this.subcomments.add(comment);
    }

}
