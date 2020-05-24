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
        if (tag.equals("")) {
            return;
        }
        if (tag == null){
            this.tagFilter.clear();
        }
        if (this.tagFilter.contains(tag)) {
            return;
        }
        this.tagFilter.add(tag);
    }

    public void removeTagFilter(String tag) {
        this.tagFilter.remove(tag);
    }

    private ArrayList<Post> getTagFilteredPost(ArrayList<Post> post) {
        if (this.tagFilter.size() == 0) {
            return post;
        }
        var filteredPosts = new  ArrayList<Post>();
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
        if (this.authorFilter.size() == 0) {
            return post;
        }
        var filteredPosts = new  ArrayList<Post>();
        for (Post p : post) {
            if (this.authorFilter.contains(p.getAuthorId())) {
                filteredPosts.add(p);
            }
        }
        return filteredPosts;
    }

    public void clearTagFilter() {
        this.tagFilter.clear();
    }

    public void clearAuthorFilter() {
        this.authorFilter.clear();
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

    public void setAuthorFilter(String author) {
        if (author.equals("")) {
            return;
        }
        if (author == null) {
            this.authorFilter.clear();
        }
        if (this.authorFilter.contains(author)) {
            return;
        }
        this.authorFilter.add(author);
    }

    public ArrayList<String> getAuthorFilter() {
        return this.authorFilter;
    }

    public ArrayList<String> getTagFilter() {
        return this.tagFilter;
    }
}
