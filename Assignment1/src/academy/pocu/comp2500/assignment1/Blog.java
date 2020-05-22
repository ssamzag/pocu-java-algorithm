package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.UUID;

public class Blog {
    private final UUID blogId;
    private final String userId;
    private ArrayList<Post> postList;
    private SortingType sortingType;


    public Blog(User user) {
        this.blogId = UUID.randomUUID();
        this.userId = user.getUserId();
    }

    public void addPost(Post post) {
        if (this.postList == null) {
            this.postList = new ArrayList<Post>();
        }
        postList.add(post);
    }

    public void getPostList() {

    }

    public void setOrder(SortingType type) {
        this.sortingType = type;
    }

    public void setTagFilter() {

    }
    public void setAuthorFilter() {

    }
}
