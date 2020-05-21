package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Interface;
import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("POst", "setTagFilter");
        registry.registerAuthorFilterSetter("Post", "setAuthorFilter");
        registry.registerPostOrderSetter("Post", "setSortOrder");
        registry.registerPostListGetter("Post", "getPostList");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Post", "modifyPostTitle");
        registry.registerPostBodyUpdater("Post", "modifyPostBody");
        registry.registerPostTagAdder("Post", "addTag");
        registry.registerCommentAdder("Post", "addComment");
        registry.registerSubcommentAdder("Comment", "addComment");
        registry.registerCommentUpdater("Comment", "modifyComment");
        registry.registerSubcommentUpdater("Comment", "modifyComment");
        registry.registerReactionAdder("Post", "addReaction");
        registry.registerReactionRemover("Post", "removeReaction");
        registry.registerCommentUpvoter("Comment", "setUpVote");
        registry.registerCommentDownvoter("Comment", "setDownVote");
        registry.registerCommentListGetter("Comment", "getCommentList");
        registry.registerSubCommentListGetter("Comment", "getSubCommentList");
        registry.registerSubcommentUpvoter("Comment", "setUpVote");
        registry.registerSubcommentDownvoter("Comment", "setDownVote");
    }
}
