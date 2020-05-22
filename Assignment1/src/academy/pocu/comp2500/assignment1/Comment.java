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


    public Comment(String content, User user) {
        if (user == null) {
            return;
        }
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
        vote('U', user);
    }

    public void setDownVote(User user) {
        vote('D', user);
    }

    private void vote(char voteType, User user) {

    }

    public void addSubcomment(Comment comment) {
        this.subcomments.add(comment);
    }

}
