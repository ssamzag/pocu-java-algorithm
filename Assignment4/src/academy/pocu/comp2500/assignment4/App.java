package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerDrawPixelCommandCreator("Foo");
        // OR
        // registry.registerDrawPixelCommandCreator("Foo", "bar");
        registry.registerDrawPixelCommandCreator("DrawPixelCommand");
        registry.registerIncreasePixelCommandCreator("IncreasePixelCommand");
        registry.registerDecreasePixelCommandCreator("DecreasePixelCommand");
        registry.registerToUppercaseCommandCreator("ToUppercaseCommand");
        registry.registerToLowercaseCommandCreator("ToLowercaseCommand");
        registry.registerFillHorizontalLineCommandCreator("FillHorizontalLineCommand");
        registry.registerFillVerticalLineCommandCreator("FillVerticalLineCommand");
        registry.registerClearCommandCreator("ClearCommand");
    }
}
