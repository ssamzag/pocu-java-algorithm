package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

import java.util.HashMap;
import java.util.HashSet;

public class Program {

    public static void main(String[] args) {
        HashSet<HashMap<String, String>> test = new HashSet<HashMap<String, String>>();

        var a = new HashMap<String, String>();
        a.put("aa", "33");

        test.add(a);

        var b = new HashMap<String, String>();
        b.put("aa", "33");

        System.out.println(test.contains(b));
        test.removeIf(stringStringHashMap -> stringStringHashMap.containsKey("aa") && stringStringHashMap.containsValue("33"));
        System.out.println(a.size());


        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}
