package academy.pocu.comp2500.lab11.app;

import academy.pocu.comp2500.lab11.App;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = 33;
        int c = a + b;

        System.out.println(a);
        System.out.println(a+b);
        App app = new App();
        app.run(new BufferedReader(new InputStreamReader(System.in)), System.out, System.err);

    }
}
