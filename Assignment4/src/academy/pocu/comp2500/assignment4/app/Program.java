package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.App;
import academy.pocu.comp2500.assignment4.Canvas;

import java.awt.*;
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        Canvas canvas = new Canvas(10, 10);

//        canvas.drawPixel(0, 0, '*');
//        canvas.drawPixel(1, 2, '$');
//        canvas.drawPixel(0, 1, '&');
//        canvas.decreasePixel(1,2);
//        canvas.fillHorizontalLine(4, 'K');
//        canvas.fillVerticalLine(9, 'Y');
//        canvas.decreasePixel(0, 0);
//        canvas.decreasePixel(0, 4);
        canvas.decreasePixel(9, 0);
        System.out.println(canvas.getDrawing());

    }
}
