package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Blog {
    private final UUID blogId;
    private final String userId;
    private ArrayList<Post> postList;
    private String[] tag;

    public Blog(User user) {
        this.blogId = UUID.randomUUID();
        this.userId = user.getUserId();
    }

    public void addPost(Post post) {
        postList.add(post);
    }

    public void getPostList() {

    }

    public void setSortOrder() {

    }

    public void setTagFilter() {

    }
    public void setAuthorFilter() {

    }
}
