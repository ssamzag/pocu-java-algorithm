package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;

public class Blog {
    private final UUID blogId;
    private final User user;
    private SortingType sortingType;
    private ArrayList<Post> postList;
    private HashSet<String> tagFilter;
    private String authorFilter;

    public Blog(User user) {
        this.blogId = UUID.randomUUID();
        this.user = user;
        this.postList = new ArrayList<Post>();
        this.tagFilter = new HashSet<String>();
    }

    public void addPost(Post post) {
        this.postList.add(post);
    }

    public ArrayList<Post> getPostList() {
        ArrayList<Post> filteredPost = getTagFilteredPost(this.postList);
        filteredPost = getAuthorFilteredPost(filteredPost);
        return getSortedPost(filteredPost);
    }

    public void setOrder(SortingType type) {
        this.sortingType = type;
    }

    public void setTagFilter(String tag) {
        if (tag == null || tag.equals("")) {
            this.tagFilter.clear();
            return;
        }
        if (this.tagFilter.contains(tag)) {
            return;
        }
        this.tagFilter.add(tag);
    }

    public void removeTagFilter(String tag) {
        this.tagFilter.remove(tag);
    }

    public void setAuthorFilter(String author) {
        if (author == null) {
            this.authorFilter = "";
            return;
        }
        this.authorFilter = author;
    }

    private ArrayList<Post> getTagFilteredPost(ArrayList<Post> post) {
        if (this.tagFilter.size() == 0 || this.tagFilter == null) {
            return post;
        }

        var filteredPosts = new ArrayList<Post>();
        for (Post p : post) {
            for (var filter : this.tagFilter) {
                if (p.getTags().contains(filter)) {
                    filteredPosts.add(p);
                    break;
                }
            }
        }
        return filteredPosts;
    }

    private ArrayList<Post> getAuthorFilteredPost(ArrayList<Post> post) {
        if (this.authorFilter == null || this.authorFilter.equals("")) {
            return post;
        }
        return post
                .stream()
                .filter(p -> this.authorFilter.equals(p.getAuthorId()))
                .collect(Collectors.toCollection(() -> new ArrayList<Post>()));
    }

    public void clearTagFilter() {
        this.tagFilter.clear();
    }

    public void clearAuthorFilter() {
        this.authorFilter = "";
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
                return post;
        }
    }

    public HashSet<String> getTagFilter() {
        return this.tagFilter;
    }
}
