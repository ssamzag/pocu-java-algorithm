package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

public class Comment {
    private final UUID commentId;
    private final User user;
    private String content;
    private final ArrayList<Comment> subcommentList;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private final HashMap<User, String> votes;

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
        this.content = content;
        this.modifiedDateTime = OffsetDateTime.now();
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
            this.votes.put(user, voteType);
            return;
        }
        this.votes.remove(user);
        if (userVote.equals(voteType)) {
            return;
        }
        this.votes.put(user, voteType);
    }

    public void removeVote(User user) {
        this.votes.remove(user);
    }

    public long getVoteCount(String voteType) {
        return this.votes.entrySet().stream().filter(map -> voteType.equals(map.getValue())).count();
    }

    public long getCalculatedVoteCount() {
        return getVoteCount("U") - getVoteCount("D");
    }

    public void addSubcomment(Comment comment) {
        this.subcommentList.add(comment);
    }

    public ArrayList<Comment> getSubcommentList() {
        return this.subcommentList.stream()
                .sorted(Comparator.comparing(Comment::getCalculatedVoteCount).reversed())
                .collect(Collectors.toCollection(() -> new ArrayList<Comment>()));
    }

    public UUID getCommentId() {
        return this.commentId;
    }

    public User getUser() {
        return user;
    }

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public HashMap<User, String> getVotes() {
        return votes;
    }
}
