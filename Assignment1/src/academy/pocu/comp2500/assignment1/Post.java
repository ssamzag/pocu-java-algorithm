package academy.pocu.comp2500.assignment1;


import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;
import java.time.OffsetDateTime;

public class Post {
    private final UUID postId;
    private final User user;
    private String title;
    private String body;
    private String authorId;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private final HashSet<HashMap<User, ReactionType>> reactions;
    private final ArrayList<String> tags;
    private final ArrayList<Comment> commentList;

    public Post(String title, String body, User user) {
        this.postId = UUID.randomUUID();
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
        this.user = user;
        this.authorId = user.getUserId();
        this.title = title;
        this.body = body;
        this.tags = new ArrayList<String>();
        this.commentList = new ArrayList<Comment>();
        this.reactions = new HashSet<HashMap<User, ReactionType>>();
    }

    public void updateBody(String body) {
        this.body = body;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    public void setTag(String tag) {
        if (!this.tags.remove(tag)) {
            this.tags.add(tag);
        }
    }
    public ArrayList<String> getTags() {
        return this.tags;
    }

    public void updateTitle(String title) {
        this.title = title;
        this.modifiedDateTime = OffsetDateTime.now();
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

    public String getPostString() {
        return String.format("제목 : " + this.title + ", " + "내용 : " + this.body + "%s", System.lineSeparator());
    }

    public void addReaction(User user, ReactionType type) {
        var reaction = new HashMap<User, ReactionType>();
        reaction.put(user, type);
        if (reactions.contains(reaction)) {
            removeReaction(user, type);
            return;
        }

        this.reactions.add(reaction);
    }

    public void removeReaction(User user, ReactionType type) {
        var reaction = new HashMap<User, ReactionType>();
        reaction.put(user, type);
        reactions.remove(reaction);
    }

    public HashSet<HashMap<User, ReactionType>> getReactions() {
        return this.reactions;
    }

    public int getReactionCount() {
        return this.reactions.size();
    }

    public String getReaction() {
        StringBuilder sb = new StringBuilder();
        reactions.forEach(set -> {
            sb.append(set
                    .entrySet()
                    .stream()
                    .map(map -> map.getKey().getUserId() + ":" + map.getValue().toString() + ",")
                    .collect(Collectors.joining()));
        });

        return sb.toString();
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

    public User getUser() {
        return this.user;
    }

    public ArrayList<Comment> getCommentList() {
        return this.commentList
                .stream()
                .sorted(Comparator.comparing(Comment::getCalculatedVoteCount).reversed())
                .collect(Collectors.toCollection(() -> new ArrayList<Comment>()));
    }

    public UUID getPostId() {
        return postId;
    }

    public String getAuthorId() {
        return this.authorId;
    }

}
