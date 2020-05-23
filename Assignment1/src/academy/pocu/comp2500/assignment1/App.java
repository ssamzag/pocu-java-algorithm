package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Interface;
import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "setTagFilter");
        registry.registerAuthorFilterSetter("Blog", "setAuthorFilter");
        registry.registerPostOrderSetter("Blog", "setOrder");
        registry.registerPostListGetter("Blog", "getPostList");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Post", "updateTitle");
        registry.registerPostBodyUpdater("Post", "updateBody");
        registry.registerPostTagAdder("Post", "setTag");
        registry.registerCommentAdder("Post", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubcomment");
        registry.registerCommentUpdater("Comment", "updateContent");
        registry.registerSubcommentUpdater("Comment", "updateContent");
        registry.registerReactionAdder("Post", "addReaction");
        registry.registerReactionRemover("Post", "removeReaction");
        registry.registerCommentUpvoter("Comment", "setUpVote");
        registry.registerCommentDownvoter("Comment", "setDownVote");
        registry.registerCommentListGetter("Post", "getCommentList");
        registry.registerSubCommentListGetter("Comment", "getSubcommentList");
        registry.registerSubcommentUpvoter("Comment", "setUpVote");
        registry.registerSubcommentDownvoter("Comment", "setDownVote");
    }
}
