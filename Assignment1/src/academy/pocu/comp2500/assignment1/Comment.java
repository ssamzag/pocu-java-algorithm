package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;
import java.time.OffsetDateTime;

public class Comment {
    private final UUID commentId;
    private final User user;
    private String content;
    private final ArrayList<Comment> subcommentList;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private final HashMap<User, VoteType> votes;

    public Comment(String content, User user) {
        this.commentId = UUID.randomUUID();
        this.content = content;
        this.user = user;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
        this.subcommentList = new ArrayList<Comment>();
        this.votes = new HashMap<User, VoteType>();
    }

    public void updateContent(String content) {
        this.content = content;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    public String getContent() {
        return this.content;
    }

    public void setUpVote(User user) {
        vote(user, VoteType.UP);
    }

    public void setDownVote(User user) {
        vote(user, VoteType.DOWN);
    }

    private void vote(User user, VoteType type) {
        VoteType userVote = votes.get(user);
        if (userVote == null) {
            this.votes.put(user, type);
            return;
        }
        this.votes.remove(user);
        if (userVote.equals(type)) {
            return;
        }
        this.votes.put(user, type);
    }

    public void removeVote(User user) {
        this.votes.remove(user);
    }

    public long getVoteCount(VoteType voteType) {
        return this.votes.entrySet().stream().filter(map -> voteType.equals(map.getValue())).count();
    }

    public long getCalculatedVoteCount() {
        return getVoteCount(VoteType.UP) - getVoteCount(VoteType.DOWN);
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

    public HashMap<User, VoteType> getVotes() {
        return votes;
    }
}
