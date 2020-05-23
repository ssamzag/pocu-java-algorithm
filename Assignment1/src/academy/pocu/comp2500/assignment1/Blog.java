package academy.pocu.comp2500.assignment1;

import java.lang.reflect.Array;
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
        ArrayList<Post> filteredPost = getFilteredPost(this.postList, this.tagFilter);
        filteredPost = getFilteredPost(filteredPost, this.authorFilter);
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
        var filteredPosts = new  ArrayList<Post>();
        for (Post p : post) {
            if (p.hasTags(this.tagFilter)) {
                filteredPosts.add(p);
            }
        }
        return filteredPosts;
    }

    public ArrayList<Post> getFilteredPost(ArrayList<Post> post, ArrayList<String> filter) {
        var filteredPosts = new  ArrayList<Post>();
        for (Post p : post) {
            if (p.hasTags(filter)) {
                filteredPosts.add(p);
            }
        }
        return filteredPosts;
    }

    public ArrayList<Post> getSortedPost(ArrayList<Post> post) {
        var a = Comparator.comparing(Post::getCreatedDateTime);

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

    public ArrayList<String> getAuthorFilter() {
        return this.authorFilter;
    }

    public ArrayList<String> getTagFilter() {
        return this.authorFilter;
    }

    public SortingType getSortingType() {
        return this.sortingType;
    }

    public User getUser() {
        return this.user;
    }

    public UUID getBlogId() {
        return this.blogId;
    }

}
