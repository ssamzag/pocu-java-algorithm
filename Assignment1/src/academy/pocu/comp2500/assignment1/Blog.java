package academy.pocu.comp2500.assignment1;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static academy.pocu.comp2500.assignment1.SortingType.*;

public class Blog {
    private final UUID blogId;
    private final String userId;
    private ArrayList<Post> postList;
    private SortingType sortingType;
    private HashSet<String> tagFilter;
    private HashSet<String> authorFilter;

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

    public ArrayList<Post> getPostList() {
        // tag Filter
        ArrayList<Post> filteredPost = postList.stream().filter(post ->
            post.getPostByTagFilterOrNull(tagFilter) != null
        ).collect(Collectors.toCollection(()-> new ArrayList<Post>()));

        if (filteredPost == null) {
            return new ArrayList<Post>();
        }
        // authorFilter
        filteredPost = filteredPost.stream().filter(post ->
                post.getPostByAuthorFilterOrNull(this.authorFilter) != null
        ).collect(Collectors.toCollection(()-> new ArrayList<Post>()));
        // sorting
        if (filteredPost == null) {
            return new ArrayList<Post>();
        }

        return getSortedPost(filteredPost);
    }

    public void setOrder(SortingType type) {
        this.sortingType = type;
    }

    public void setTagFilter(String... tags) {
        if (this.tagFilter == null) {
            this.tagFilter = new HashSet<String>();
        }
        for (String s : tags) {
            this.tagFilter.add(s);
        }
    }

    public ArrayList<Post> getSortedPost(ArrayList<Post> post) {
        if (this.sortingType == null) {
            return post;
        }
        switch (this.sortingType) {
            case CREATED_DATE_ASC:
                return post.stream().sorted(Comparator.comparing(Post::getCreatedDateTime))
                        .collect(Collectors.toCollection(()-> new ArrayList<Post>()));
            case CREATED_DATE_DESC:
                return post.stream().sorted(Comparator.comparing(Post::getCreatedDateTime).reversed())
                        .collect(Collectors.toCollection(()-> new ArrayList<Post>()));
            case MODIFIED_DATE_ASC:
                return post.stream().sorted(Comparator.comparing(Post::getModifiedDateTime))
                        .collect(Collectors.toCollection(()-> new ArrayList<Post>()));
            case MODIFIED_DATE_DESC:
                return post.stream().sorted(Comparator.comparing(Post::getModifiedDateTime).reversed())
                        .collect(Collectors.toCollection(()-> new ArrayList<Post>()));
            default:
                return new ArrayList<Post>();
        }
    }

    public void setAuthorFilter(String... author) {
        if (this.authorFilter == null) {
            this.authorFilter = new HashSet<String>();
        }
        for (String s : author) {
            this.authorFilter.add(s);
        }
    }
}
