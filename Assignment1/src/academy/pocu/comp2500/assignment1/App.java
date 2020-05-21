package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Interface;
import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
         registry.registerPostAdder("Foo", "bar");

        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("","");
        registry.registerAuthorFilterSetter("","");
        registry.registerPostOrderSetter("","");
        registry.registerPostListGetter("","");
        registry.registerPostAdder("Blog","AddPost");
        registry.registerPostTitleUpdater("","");
        registry.registerPostBodyUpdater("","");
        registry.registerPostTagAdder("","");
        registry.registerCommentAdder("","");
        registry.registerSubcommentAdder("","");
        registry.registerCommentUpdater("","");
        registry.registerSubcommentUpdater("","");
        registry.registerReactionAdder("","");
        registry.registerReactionRemover("","");
        registry.registerCommentUpvoter("","");
        registry.registerCommentDownvoter("","");
        registry.registerCommentListGetter("","");
        registry.registerSubCommentListGetter("","");
        registry.registerSubcommentUpvoter("","");
        registry.registerSubcommentDownvoter("","");
    }
}
