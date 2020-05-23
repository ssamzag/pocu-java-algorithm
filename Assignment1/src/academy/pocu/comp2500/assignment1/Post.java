package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;


public class Post {
    private final UUID postId;
    private final User user;
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
        this.user = user;
        this.title = title;
        this.body = body;
    }

    public void updateTitle(String title) {
        this.title = title;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    public Post getPostByTagFilterOrNull(ArrayList<String> tagFilter) {
        if (tagFilter == null || tagFilter.size() == 0) {
            return this;
        }

        for (String tag : this.tags) {
            for(String tag2 : tagFilter) {
                if (tag.equals(tag2)) {
                    return this;
                }
            }
        }
        return null;
    }

    public Post getPostByAuthorFilterOrNull(ArrayList<String> authors) {
        if (authors == null || authors.size() == 0 || authors.contains(this.user.getUserId())) {
            return this;
        }
        return null;
    }

    public void updateBody(String body) {
        this.body = body;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    public void setTag(String tag) {
        if (this.tags == null) {
            this.tags = new HashSet<String>();
        }
        if (!tags.remove(tag)) {
            tags.add(tag);
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
        reaction.put(user, type);
        if (reactions.contains(reaction)) {
            removeReaction(type, user);
        }

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
                    .collect(Collectors.joining(",")));
        });

        return sb.toString();
    }

    public void addComment(Comment comment) {
        if (this.commentList == null) {
            this.commentList = new ArrayList<Comment>();
        }
        this.commentList.add(comment);
    }

    public ArrayList<Comment> getCommentList() {
        return this.commentList
                .stream()
                .sorted(Comparator.comparing(Comment::getCalculatedVoteCount))
                .collect(Collectors.toCollection(() -> new ArrayList<Comment>()));
    }

    public void getSubcommentList() {

    }


}
