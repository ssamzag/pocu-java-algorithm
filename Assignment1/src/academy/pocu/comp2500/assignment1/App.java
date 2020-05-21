package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Interface;
import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("", "");
        registry.registerAuthorFilterSetter("", "");
        registry.registerPostOrderSetter("", "");
        registry.registerPostListGetter("", "");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Post", "modifyPostTitle");
        registry.registerPostBodyUpdater("Post", "modifyPostBody");
        registry.registerPostTagAdder("", "");
        registry.registerCommentAdder("", "");
        registry.registerSubcommentAdder("", "");
        registry.registerCommentUpdater("", "");
        registry.registerSubcommentUpdater("", "");
        registry.registerReactionAdder("", "");
        registry.registerReactionRemover("", "");
        registry.registerCommentUpvoter("", "");
        registry.registerCommentDownvoter("", "");
        registry.registerCommentListGetter("", "");
        registry.registerSubCommentListGetter("", "");
        registry.registerSubcommentUpvoter("", "");
        registry.registerSubcommentDownvoter("", "");
    }
}
