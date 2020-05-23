package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;
import java.util.stream.Collectors;

public class Blog {
    private final UUID blogId;
    private final User user;
    private SortingType sortingType;
    private ArrayList<Post> postList;
    private ArrayList<String> tagFilter;
    private ArrayList<String> authorFilter;


    public Blog(User user) {
        this.blogId = UUID.randomUUID();
        this.user = user;
        this.postList = new ArrayList<Post>();
        this.tagFilter = new ArrayList<String>();
        this.authorFilter = new ArrayList<String>();
    }

    public void addPost(Post post) {
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

    public void setTagFilter(String tag) {
        if (!this.tagFilter.remove(tag)) {
            this.tagFilter.add(tag);
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

    public void setAuthorFilter(String author) {
        if (!this.authorFilter.remove(author)) {
            this.authorFilter.add(author);

        }
    }
}
