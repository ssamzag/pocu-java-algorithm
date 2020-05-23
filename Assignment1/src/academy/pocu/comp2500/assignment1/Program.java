package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

import java.util.HashMap;
import java.util.HashSet;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        var user1 = new User("Mhchoi", "ssamzag");
        var blog1 = new Blog(user1);
        var post1 = new Post("Hello, World!", "Welcome to my world!", user1);
        blog1.addPost(post1);
        var user2 = new User("MOON", "moon");
        var comment1 = new Comment("축하합니다!", user2);
        post1.addComment(comment1);
        var user3 = new User("KIM", "대중");
        var subcomment1 = new Comment("대댓글이에용", user3);
        comment1.addSubcomment(subcomment1);
        post1.addTag("태그다 캬캬");
        post1.addReaction(ReactionType.GREAT, user2);
        post1.addReaction(ReactionType.FUN, user2);
        post1.addReaction(ReactionType.GREAT, user2);
        post1.addReaction(ReactionType.GREAT, user3);
        System.out.println("리액션 : " + post1.getReaction());
        comment1.setUpVote(user2);
        subcomment1.setUpVote(user3);
        subcomment1.setUpVote(user2);
        subcomment1.setUpVote(user3);
        subcomment1.setUpVote(user3);
        System.out.println(post1.getPost());
        System.out.println("좋아요 " + subcomment1.getUpVoteCount());
        System.out.println("싫어요 " + subcomment1.getDownVoteCount());

        subcomment1.setDownVote(user3);
        System.out.println("좋아요 " + subcomment1.getUpVoteCount());
        System.out.println("싫어요 " + subcomment1.getDownVoteCount());

        System.out.println("태그 카운트 : " + blog1.getPostList().size());

        var post2 = new Post("hihi", "fuck", user2);
        Thread.sleep(100);
        var post3 = new Post("hihi444", "fuck", user2);
        Thread.sleep(100);
        var post4 = new Post("hihi555", "fuck", user2);
        Thread.sleep(100);

        blog1.addPost(post2);
        blog1.addPost(post3);
        blog1.addPost(post4);

        blog1.setOrder(SortingType.CREATED_DATE_ASC);
        var a = blog1.getPostList();
        blog1.setOrder(SortingType.CREATED_DATE_DESC);
        var b = blog1.getPostList();

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}
