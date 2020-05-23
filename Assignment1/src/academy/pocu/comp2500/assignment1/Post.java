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
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private HashSet<HashMap<User, ReactionType>> reactions;
    private ArrayList<String> tags;
    private ArrayList<Comment> commentList;

    public Post(String title, String body, User user) {
        this.postId = UUID.randomUUID();
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
        this.user = user;
        this.title = title;
        this.body = body;
        this.tags = new ArrayList<String>();
        this.commentList = new ArrayList<Comment>();
        this.reactions = new HashSet<HashMap<User, ReactionType>>();
    }

    public void updateTitle(String title) {
        this.title = title;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    public boolean hasTags(ArrayList<String> tagFilter) {
        if (tagFilter == null || tagFilter.size() == 0) {
            return true;
        }

        for (String tag : this.tags) {
            for(String tag2 : tagFilter) {
                if (tag.equals(tag2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Post getPost() {
        return this;
    }

    public boolean hasAuthors(ArrayList<String> authors) {
        if (authors == null || authors.size() == 0 || authors.contains(this.user.getUserId())) {
            return true;
        }
        return false;
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

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }


    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }

    public String getPostString() {
        return String.format("제목 : " + this.title + "%S" + "내용 : " + this.body, System.lineSeparator());
    }

    public void addReaction(User user, ReactionType type) {
        var reaction = new HashMap<User, ReactionType>() {
            {
                put(user, type);
            }
        };
        if (reactions.contains(reaction)) {
            removeReaction(user, type);
            return;
        }

        this.reactions.add(reaction);
    }

    public void removeReaction(User user, ReactionType type) {
        reactions.remove(new HashMap<User, ReactionType>() {
            {
                put(user, type);
            }
        });
    }

    public HashSet<HashMap<User, ReactionType>> getReactions() {
        return this.reactions;
    }

    public String getReaction() {
        StringBuilder sb = new StringBuilder();
        reactions.forEach(set -> {
            sb.append(set
                    .entrySet()
                    .stream()
                    .map(map -> map.getKey().getUserId() + ":" + map.getValue().toString() + ",")
                    .collect(Collectors.joining(",")));
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
                .sorted(Comparator.comparing(Comment::getCalculatedVoteCount))
                .collect(Collectors.toCollection(() -> new ArrayList<Comment>()));
    }

    public UUID getPostId() {
        return postId;
    }

}
