package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        var user1 = new User("Mhchoi");
        var blog1 = new Blog(user1);
        var post1 = new Post("Hello, World!", "Welcome to my world!", user1);
        blog1.addPost(post1);

        System.out.println(blog1.getPostList().size());
        var user2 = new User("MOON");
        var comment1 = new Comment("축하합니다!", user2);
        post1.addComment(comment1);
        var user3 = new User("KIM");
        var subcomment1 = new Comment("대댓글이에용", user3);
        comment1.addSubcomment(subcomment1);
        post1.setTag("태그다 캬캬");
        post1.addReaction(user2, ReactionType.GREAT);
        post1.addReaction(user2, ReactionType.FUN);
        post1.addReaction(user2, ReactionType.GREAT);
        post1.addReaction(user3, ReactionType.GREAT);
        System.out.println("리액션 : " + post1.getReaction());
        comment1.setUpVote(user2);
        subcomment1.setUpVote(user3);
        System.out.println("좋아요 " + subcomment1.getVoteCount("U"));
        System.out.println("싫어요 " + subcomment1.getVoteCount("D"));
        System.out.println("--------------------------------------------------");
        subcomment1.setUpVote(user2);
        System.out.println("좋아요 " + subcomment1.getVoteCount("U"));
        System.out.println("싫어요 " + subcomment1.getVoteCount("D"));
        System.out.println("--------------------------------------------------");
        subcomment1.setUpVote(user3);
        System.out.println("좋아요 " + subcomment1.getVoteCount("U"));
        System.out.println("싫어요 " + subcomment1.getVoteCount("D"));
        System.out.println("--------------------------------------------------");
        subcomment1.setUpVote(user3);
        System.out.println("좋아요 " + subcomment1.getVoteCount("U"));
        System.out.println("싫어요 " + subcomment1.getVoteCount("D"));
        System.out.println("--------------------------------------------------");
        System.out.println(post1.getPostString());
        System.out.println("좋아요 " + subcomment1.getVoteCount("U"));
        System.out.println("싫어요 " + subcomment1.getVoteCount("D"));
        System.out.println("--------------------------------------------------");
        subcomment1.setDownVote(user3);

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

        System.out.println("포스트 글개수 :" + blog1.getPostList().size());

        blog1.setOrder(SortingType.CREATED_DATE_ASC);
        var a = blog1.getPostList();
        blog1.setOrder(SortingType.CREATED_DATE_DESC);
        var b = blog1.getPostList();

        System.out.println("포스트 글개수 :" + blog1.getPostList().size());

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}
