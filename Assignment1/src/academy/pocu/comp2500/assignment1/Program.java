package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

import java.util.HashSet;

public class Program {

    public static void main(String[] args) {
        HashSet<String> s = new HashSet<String>();

        s.add("dd");
        s.add("dd");
        s.add("dd");

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}
