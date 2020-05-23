package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        var user1 = new User("a1");
        var user2 = new User("a2");

        var blog1 = new Blog(user1);
        var post1 = new Post("p1", "body", user1);
        var post2 = new Post("p2", "body", user1);
        var post3 = new Post("p3", "body", user2);
        blog1.addPost(post1);
        blog1.addPost(post2);
        blog1.addPost(post3);

        post1.setTag("t1");
        post2.setTag("t2");
        post3.setTag("t1");
        post3.setTag("t2");

        blog1.setTagFilter("t1");

        System.out.println();
        System.out.println("t1 태그 추가 : \r\n" +
                blog1.getPostList().stream().map(m -> m.getPostString()).collect(Collectors.joining()));

        blog1.clearTagFilter();
        System.out.println("--tag 초기화--");
        blog1.setTagFilter("t2");
        System.out.println("t2 태그 추가 : \r\n" +
                blog1.getPostList().stream().map(m -> m.getPostString()).collect(Collectors.joining()));

        blog1.clearTagFilter();
        System.out.println("--tag 초기화--");

        blog1.setTagFilter("t1");
        blog1.setTagFilter("t2");

        System.out.println("t1 t2 태그 추가 : \r\n" +
                blog1.getPostList().stream().map(m -> m.getPostString()).collect(Collectors.joining()));

        blog1.clearTagFilter();
        System.out.println("--tag 초기화--");
        System.out.println("--test case 2 시작---------");

        var blog2 = new Blog(user1);
        var post2_1 = new Post("p1", "body", user1);
        var post2_2 = new Post("p2", "body", user1);
        var post2_3 = new Post("p3", "body", user2);
        var post2_4 = new Post("p4", "body", user2);
        blog2.addPost(post2_1);
        blog2.addPost(post2_2);
        blog2.addPost(post2_3);
        blog2.addPost(post2_4);

        post2_1.setTag("t1");
        post2_2.setTag("t2");
        post2_3.setTag("t1");
        post2_4.setTag("t2");

        blog2.setTagFilter("t1");

        System.out.println("t1 태그 추가 : \r\n" +
                blog2.getPostList().stream().map(m -> m.getPostString()).collect(Collectors.joining()));

        System.out.println("Start Test 2");
        blog2.clearTagFilter();
        blog2.setAuthorFilter("a1");
        System.out.println("test2 : \r\n" +
                blog2.getPostList().stream().map(m -> m.getPostString()).collect(Collectors.joining()));

        System.out.println("Start Test 3");
        blog2.clearAuthorFilter();
        blog2.setTagFilter("t1");
        blog2.setAuthorFilter("a2");
        System.out.println("test 3 : \r\n" +
                blog2.getPostList().stream().map(m -> m.getPostString()).collect(Collectors.joining()));
        blog2.clearAuthorFilter();
        blog2.clearTagFilter();
        System.out.println("Start Test4");
        blog2.setTagFilter("t2");
        blog2.setAuthorFilter("a1");
        System.out.println("test 4 : \r\n" +
                blog2.getPostList().stream().map(m -> m.getPostString()).collect(Collectors.joining()));

        var comment1 = new Comment("c1", user1);
        var comment2 = new Comment("c2", user1);
        var comment3 = new Comment("c3", user2);
        var comment4 = new Comment("c4", user2);
        var subcomment1 = new Comment("s1", user2);
        var subcomment2 = new Comment("s2", user2);
        var subcomment3 = new Comment("s3", user2);
        var subcomment4 = new Comment("s4", user2);

        comment1.addSubcomment(subcomment1);
        comment1.addSubcomment(subcomment2);
        comment1.addSubcomment(subcomment3);
        subcomment3.addSubcomment(subcomment4);

        post2_1.addComment(comment1);
        post2_1.addComment(comment2);
        post2_1.addComment(comment3);
        post2_1.addComment(comment4);

        subcomment1.setUpVote(user1);
        subcomment1.setUpVote(user2);
        subcomment2.setDownVote(user1);

        comment2.setUpVote(user1);

        var a = post2_1.getCommentList();
        var b = comment1.getSubcommentList();
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}
