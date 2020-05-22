package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;

public class Post {
    private final UUID postId;
    private final String authorId;
    private String title;
    private String body;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private HashSet<HashMap<User, ReactionType>> reactions;
    private HashSet<String> tags;
    private ArrayList<Comment> commentList;

    public Post(String title, String body, User user) {
        this.postId = UUID.randomUUID();
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
        this.authorId = user.getUserId();
        this.title = title;
        this.body = body;
    }

    public void updateTitle(String title) {
        this.title = title;
        this.modifiedDateTime = OffsetDateTime.now();

    }

    public void updateBody(String body) {
        this.body = body;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    public void addTag(String tag) {
        if (this.tags == null) {
            this.tags = new HashSet<String>();
        }
        tags.add(tag);
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

    public String getPost() {
        return String.format("제목 : " + this.title + "%S" + "내용 : " + this.body, System.lineSeparator());
    }

    public void addReaction(ReactionType type, User user) {
        if (this.reactions == null) {
            this.reactions = new HashSet<HashMap<User, ReactionType>>();
        }

        var reaction = new HashMap<User, ReactionType>();
        if (reactions.contains(reaction)) {
            removeReaction(type, user);
        }
        reaction.put(user, type);
        this.reactions.add(reaction);
    }

    public void removeReaction(ReactionType type, User user) {
        var reaction = new HashMap<User, ReactionType>();
        reaction.put(user, type);
        reactions.remove(reaction);

    }

    public String getReaction() {
        StringBuilder sb = new StringBuilder();
        reactions.forEach(set -> {
            sb.append(set
                    .entrySet()
                    .stream()
                    .map(map -> map.getValue().toString())
                    .collect(Collectors.joining()));
        });

        return sb.toString();
    }

    public void addComment(Comment comment) {
        if (this.commentList == null) {
            this.commentList = new ArrayList<Comment>();
        }
        this.commentList.add(comment);
    }

    public void getCommentList() {
        var a = SortingType.CREATED_DATE_ASC;
    }

    public void getSubcommentList() {
    }


}
