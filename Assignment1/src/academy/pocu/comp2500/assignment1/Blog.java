package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.UUID;

public class Blog {
    private UUID blogId;
    private String userId;
    private ArrayList<Post> postList;

    public Blog(User user) {
        this.blogId = UUID.randomUUID();
        this.userId = user.getUserId();
    }

    public void AddPost(Post post) {
        postList.add(post);
    }

}
