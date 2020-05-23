package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Comment {
    private UUID commentId;
    private User user;
    private String content;
    private ArrayList<Comment> subcommentList;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private HashMap<User, String> votes;

    public Comment(String content, User user) {
        this.commentId = UUID.randomUUID();
        this.content = content;
        this.user = user;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
        this.subcommentList = new ArrayList<Comment>();
        this.votes = new HashMap<User, String>();
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
        vote(user, "U");
    }

    public void setDownVote(User user) {
        vote(user, "D");
    }

    private void vote(User user, String voteType) {
        String userVote = votes.get(user);
        if (userVote == null) {
            votes.put(user, voteType);
            return;
        }
        votes.remove(user);
        if (userVote.equals(voteType)) {
            return;
        }
        votes.put(user, voteType);
    }

    public long getUpVoteCount() {
        return this.votes.entrySet().stream().filter(map -> "U".equals(map.getValue())).count();
    }

    public long getDownVoteCount() {
        return this.votes.entrySet().stream().filter(map -> "D".equals(map.getValue())).count();
    }

    public long getCalculatedVoteCount() {
        return getUpVoteCount() - getDownVoteCount();
    }

    public void addSubcomment(Comment comment) {
        this.subcommentList.add(comment);
    }

    public ArrayList<Comment> getSubcommentList() {
        return this.subcommentList;
    }

}
