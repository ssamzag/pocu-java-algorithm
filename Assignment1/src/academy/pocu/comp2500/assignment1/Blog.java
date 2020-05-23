package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;

public class Blog {
    private final UUID blogId;
    private final User user;
    private ArrayList<Post> postList;
    private SortingType sortingType;
    private HashSet<String> tagFilter;
    private HashSet<String> authorFilter;

    public Blog(User user) {
        this.blogId = UUID.randomUUID();
        this.user = user;
    }

    public void addPost(Post post) {
        if (this.postList == null) {
            this.postList = new ArrayList<Post>();
        }
        postList.add(post);
    }

    public ArrayList<Post> getPostList() {
        ArrayList<Post> filteredPost;
        filteredPost = getTagFilteredPost(this.postList);
        filteredPost = getAuthorFilteredPost(filteredPost);
        return getSortedPost(filteredPost);
    }

    public void setOrder(SortingType type) {
        this.sortingType = type;
    }

    public void setTagFilter(String... tags) {
        if (this.tagFilter == null) {
            this.tagFilter = new HashSet<String>();
        }
        for (String tag : tags) {
            if (!tagFilter.remove(tag)) {
                this.tagFilter.add(tag);
            }
        }
    }

    public ArrayList<Post> getTagFilteredPost(ArrayList<Post> post) {
        return postList.stream().filter(p ->
                p.getPostByTagFilterOrNull(tagFilter) != null
        ).collect(Collectors.toCollection(() -> new ArrayList<Post>()));
    }

    public ArrayList<Post> getAuthorFilteredPost(ArrayList<Post> post) {
        return post.stream().filter(p ->
                p.getPostByAuthorFilterOrNull(this.authorFilter) != null
        ).collect(Collectors.toCollection(()-> new ArrayList<Post>()));
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
            case TITLE_ASC:
                return post.stream().sorted(Comparator.comparing(Post::getTitle))
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
            if (!this.authorFilter.remove(s)) {
                this.authorFilter.add(s);
            }
        }
    }
}
