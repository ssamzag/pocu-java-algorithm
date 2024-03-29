package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.App;
import academy.pocu.comp2500.assignment4.Canvas;
import academy.pocu.comp2500.assignment4.ClearCommand;
import academy.pocu.comp2500.assignment4.CommandHistoryManager;
import academy.pocu.comp2500.assignment4.DecreasePixelCommand;
import academy.pocu.comp2500.assignment4.DrawPixelCommand;
import academy.pocu.comp2500.assignment4.FillHorizontalLineCommand;
import academy.pocu.comp2500.assignment4.FillVerticalLineCommand;
import academy.pocu.comp2500.assignment4.ICommand;
import academy.pocu.comp2500.assignment4.IncreasePixelCommand;
import academy.pocu.comp2500.assignment4.OverdrawAnalyzer;
import academy.pocu.comp2500.assignment4.ToLowercaseCommand;
import academy.pocu.comp2500.assignment4.ToUppercaseCommand;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {

        Canvas canvas = new OverdrawAnalyzer(30, 30);
        {

            OverdrawAnalyzer canvas2 = new OverdrawAnalyzer(5, 5);
            var manager = new CommandHistoryManager(canvas2);

            var toUpper1 = new ToUppercaseCommand(3, 4);
            var toLower1 = new ToLowercaseCommand(0, 1);
            var clear1 = new ClearCommand();
            var inc1 = new IncreasePixelCommand(2,2);
            var dec1 = new DecreasePixelCommand(1, 3);//5
            var inc2 = new IncreasePixelCommand(1,2);
            var clear2 = new ClearCommand();
            var fillH1 = new FillHorizontalLineCommand(4, 'p');//5
            var inc3 = new IncreasePixelCommand(2,1);
            var inc4 = new IncreasePixelCommand(3,1);
            var toUpper2 = new ToUppercaseCommand(2, 2);
            var fillH2 = new FillHorizontalLineCommand(0, ' ');//5
            var fillH3 = new FillHorizontalLineCommand(4, 'D');//5


            int i = 1;
            manager.undo();
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(toUpper1);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(toLower1);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(clear1);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(inc1);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(dec1);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());
            System.out.println(canvas2.getDrawing());

            manager.execute(inc2);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());
            System.out.println(canvas2.getDrawing());

            manager.undo();
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());
            System.out.println(canvas2.getDrawing());

            manager.undo();
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());
            System.out.println(canvas2.getDrawing());

            manager.execute(clear2);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(fillH1);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.redo();
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.undo();
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(inc3);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(inc4);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(toUpper2);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.undo();
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(fillH2);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.undo();
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

            manager.execute(fillH3);
            System.out.print(i++ + ". ");
            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());

        }

//        {
//            OverdrawAnalyzer canvas2 = new OverdrawAnalyzer(5, 5);
//            var manager = new CommandHistoryManager(canvas2);
//
//            var toUpper1 = new ToUppercaseCommand(2, 0);
//            var toUpper2 = new ToUppercaseCommand(0, 1);
//            var toLower1 = new ToLowercaseCommand(4, 3);
//
//            var fillH1 = new FillHorizontalLineCommand(0, 'e');//5
//            var dec1 = new DecreasePixelCommand(4, 4);//5
//            var dec2 = new DecreasePixelCommand(0, 1);
//            var toLower2 = new ToLowercaseCommand(0, 0);
//            var draw1 = new DrawPixelCommand(3, 2, 'Z');
//            var inc1 = new IncreasePixelCommand(3,4);
//            var toUpper3 = new ToUppercaseCommand(4, 4);
//            var draw2 = new DrawPixelCommand(4, 0, '+');
//            var fillV1 = new FillVerticalLineCommand(4, '^');
//            var toLower3 = new ToLowercaseCommand(0, 3);
//            var toLower4 = new ToLowercaseCommand(1, 0);
//            var toLower5 = new ToLowercaseCommand(1, 3);
//            var fillV2 = new FillVerticalLineCommand(3, 'I');
//            var inc2 = new IncreasePixelCommand(4,4);
//            int i = 1;
//
//            manager.execute(toUpper1);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//            manager.execute(toUpper2);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//            manager.execute(toLower1);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//            manager.execute(fillH1);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//            manager.execute(dec1);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());
//            System.out.println(canvas2.getDrawing());
//            manager.execute(dec2);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());
//            System.out.println(canvas2.getDrawing());
//            manager.execute(toLower2);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());
//            System.out.println(canvas2.getDrawing());
//            manager.execute(draw1);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());
//            System.out.println(canvas2.getDrawing());
//            manager.execute(inc1);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.execute(toUpper3);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.execute(draw2);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.execute(fillV1);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.execute(toLower3);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.execute(toLower4);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.redo();
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.undo();
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.execute(toLower5);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.execute(fillV2);
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//            manager.execute(inc2);
//            System.out.print(i++ + ". ");System.out.println(canvas2.getOverdrawCount());System.out.println(canvas2.getDrawing());
//
//
//            manager.redo();
//            System.out.print(i++ + ". ");
//            System.out.println(canvas2.getOverdrawCount());
//            System.out.println(canvas2.getDrawing());
//        }
//        {
//            var manager = new CommandHistoryManager(canvas);
//            var fillHo = new FillHorizontalLineCommand(4, 'X');
//            manager.execute(fillHo);
//            var fillv = new FillHorizontalLineCommand(4, 'V');
//            manager.execute(fillv);
//
//            var tlow = new ToLowercaseCommand(0, 4);
//            manager.execute(tlow);
//
//        }
//        {
//            var fh1 = new IncreasePixelCommand(10, 10);
//            var fh2 = new IncreasePixelCommand(10, 10);
//            fh1.execute(canvas);
//            fh2.execute(canvas);
//
//            var fv = new IncreasePixelCommand(10, 10);
//            var fh = new DecreasePixelCommand(10, 10);
//            fv.execute(canvas);
//            fh.execute(canvas);
//            System.out.println(canvas.getDrawing());
//            fv.undo();
//            System.out.println(canvas.getDrawing());
//            fh.undo();
//            System.out.println(canvas.getDrawing());
//        }
//        {
//            var manager = new CommandHistoryManager(canvas);
//            var fv = new FillVerticalLineCommand(21, '8');
//            manager.execute(fv);
//            System.out.println(canvas.getDrawing());
//            manager.undo();
//            System.out.println(canvas.getDrawing());
//            fv.redo();
//            System.out.println(canvas.getDrawing());
//            manager.undo();
//            System.out.println(canvas.getDrawing());
//        }
//
//        {
//            var manager = new CommandHistoryManager(canvas);
//            var fv = new FillVerticalLineCommand(21, '8');
//            manager.execute(fv);
//            var ip = new IncreasePixelCommand(21, 2);
//            manager.execute(ip);
//        }
//        {
//            var manager = new CommandHistoryManager(canvas);
//            var fv = new FillVerticalLineCommand(21, '8');
//            var fh = new FillHorizontalLineCommand(10, '#');
//            var tlower = new ToLowercaseCommand(5, 1);
//            manager.execute(fv);
//            manager.execute(fh);
//            manager.execute(tlower);
//            manager.redo();
//            manager.undo();
//            System.out.println(canvas.getDrawing());
//
//        }
//
//        {
//
//            System.out.println(canvas.getDrawing());
//            var manager = new CommandHistoryManager(canvas);
//            assert !manager.canRedo();
//            assert !manager.canUndo();
//            ICommand command = new DrawPixelCommand(0, 0, (char)126);
//            manager.execute(command);
//            System.out.println(canvas.getDrawing());
//            assert !manager.canRedo();
//            assert manager.canUndo();
//            assert manager.undo();
//            System.out.println(canvas.getDrawing());
//
//            ICommand command2 = new DrawPixelCommand(0, 1, (char)126);
//            assert manager.execute(command2);
//            assert !manager.execute(command2);
//            System.out.println(canvas.getDrawing());
//            ICommand command3 = new DrawPixelCommand(0, 2, (char)124);
//            assert manager.execute(command3);
//            System.out.println(canvas.getDrawing());
//            assert manager.undo();
//            System.out.println(canvas.getDrawing());
//            assert manager.undo();
//            System.out.println(canvas.getDrawing());
//            assert !manager.undo();
//            System.out.println(canvas.getDrawing());
//            assert manager.redo();
//            System.out.println(canvas.getDrawing());
//            assert manager.redo();
//            System.out.println(canvas.getDrawing());
//            assert !manager.redo();
//            System.out.println(canvas.getDrawing());
//        }
//        {
//            System.out.println(canvas.getDrawing());
//            ICommand command = new DrawPixelCommand(0, 0, (char)126);
//
//            command.execute(canvas);
//            System.out.println(canvas.getDrawing());
//            ICommand command1 = new IncreasePixelCommand(0, 0);
//            assert !command1.undo();
//            assert !command1.undo();
//            assert !command1.redo();
//            command1.execute(canvas);
//            System.out.println(canvas.getDrawing());
//
//            assert !command1.undo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//
//            assert !command1.redo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//        }
//
//        {
//            ICommand command1 = new FillHorizontalLineCommand(1, 'k');
//            assert !command1.undo();
//            assert !command1.undo();
//            command1.execute(canvas);
//            System.out.println(canvas.getDrawing());
//
//            assert command1.undo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//
//            assert command1.redo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//        }
//        {
//            System.out.println("----vertical");
//            ICommand command1 = new FillVerticalLineCommand(3, 'm');
//            assert !command1.undo();
//            assert !command1.undo();
//            assert command1.execute(canvas);
//            assert !command1.execute(canvas);
//            System.out.println(canvas.getDrawing());
//
//            assert command1.undo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//
//            assert command1.redo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//            assert !command1.redo();
//            assert !command1.redo();
//        }
//
//        {
//            System.out.println("--- toLower");
//            ICommand command1 = new ToLowercaseCommand(1, 1);
//            assert !command1.undo();
//            assert !command1.undo();
//            assert command1.execute(canvas);
//            assert !command1.execute(canvas);
//            System.out.println(canvas.getDrawing());
//
//            assert !command1.undo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//
//            assert !command1.redo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//            assert !command1.redo();
//            assert !command1.redo();
//            assert !command1.undo();
//        }
//
//        {
//
//            System.out.println("--- toUpper");
//            ICommand command1 = new ToUppercaseCommand(1, 1);
//            assert !command1.undo();
//            assert !command1.undo();
//            assert command1.execute(canvas);
//            assert !command1.execute(canvas);
//            System.out.println(canvas.getDrawing());
//
//            assert command1.undo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//
//            assert command1.redo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//            assert !command1.redo();
//            assert !command1.redo();
//        }
//        {
//
//            System.out.println("--- Increase");
//            ICommand command1 = new IncreasePixelCommand(1, 1);
//            assert !command1.undo();
//            assert !command1.undo();
//            assert command1.execute(canvas);
//            assert !command1.execute(canvas);
//            System.out.println(canvas.getDrawing());
//
//            assert command1.undo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//
//            assert command1.redo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//            assert !command1.redo();
//            assert !command1.redo();
//        }
//
//        {
//
//            System.out.println("--- Decrease");
//            ICommand command1 = new DecreasePixelCommand(1, 1);
//            assert !command1.undo();
//            assert !command1.undo();
//            assert command1.execute(canvas);
//            assert !command1.execute(canvas);
//            System.out.println(canvas.getDrawing());
//
//            assert command1.undo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//
//            assert command1.redo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//            assert !command1.redo();
//            assert !command1.redo();
//        }
//
//        {
//
//            System.out.println("--- Decrease");
//            ICommand command1 = new ClearCommand();
//            assert !command1.undo();
//            assert !command1.undo();
//            assert command1.execute(canvas);
//            assert !command1.execute(canvas);
//            System.out.println(canvas.getDrawing());
//
//            assert command1.undo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//
//            assert command1.redo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//            assert !command1.redo();
//            assert !command1.redo();
//            assert command1.undo();
//            System.out.println(canvas.getDrawing());
//        }
//        {
//            canvas = new Canvas(5, 4);
//            canvas.drawPixel(0, 0, 'Z');
//            canvas.drawPixel(1, 2, 'b');
//            canvas.drawPixel(0, 1, 'c');
//            DrawPixelCommand command1 = new DrawPixelCommand(2, 3, 'A');
//            command1.execute(canvas);
//            //System.out.println(canvas.getDrawing());
//            assert command1.undo();
//            //System.out.println(canvas.getDrawing());
//            assert command1.redo();
//            //System.out.println(canvas.getDrawing());
//            assert command1.undo();
//            ClearCommand command2 = new ClearCommand();
//            //System.out.println(canvas.getDrawing());
//            command2.execute(canvas);
//            //System.out.println(canvas.getDrawing());
//            assert command2.undo();
//            //System.out.println(canvas.getDrawing());
//            assert command2.redo();
//            //System.out.println(canvas.getDrawing());
//            assert command2.undo();
//        }
//        {
//             canvas = new Canvas(3, 4);
//            canvas.fillHorizontalLine(0, 'A');
//            canvas.fillHorizontalLine(1, 'a');
//            canvas.fillHorizontalLine(2, '!');
//            canvas.toLower(0, 0);
//            canvas.toLower(0, 1);
//            canvas.toLower(0, 2);
//            canvas.toLower(0, 3);
//            canvas.toUpper(1, 0);
//            canvas.toUpper(1, 1);
//            canvas.toUpper(1, 2);
//            canvas.toUpper(1, 3);
//            assert canvas.getPixel(0, 0) == 'a';
//            assert canvas.getPixel(0, 1) == 'a';
//            assert canvas.getPixel(0, 2) == '!';
//            assert canvas.getPixel(0, 3) == ' ';
//            assert canvas.getPixel(1, 0) == 'A';
//            assert canvas.getPixel(1, 1) == 'A';
//            assert canvas.getPixel(1, 2) == '!';
//            assert canvas.getPixel(1, 3) == ' ';
//            assert canvas.getPixel(2, 0) == 'A';
//            assert canvas.getPixel(2, 1) == 'a';
//            assert canvas.getPixel(2, 2) == '!';
//            assert canvas.getPixel(2, 3) == ' ';
//        }
//        {
//            canvas = new Canvas(5, 4);
//            canvas.drawPixel(0, 0, 'Z');
//            canvas.drawPixel(1, 2, 'b');
//            canvas.drawPixel(0, 1, 'c');
//            DrawPixelCommand command1 = new DrawPixelCommand(2, 3, 'A');
//            //System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//            //System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//            //System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//            CommandHistoryManager manager = new CommandHistoryManager(canvas);
//            assert !manager.canRedo();
//            assert !manager.canUndo();
//            assert !manager.redo();
//            assert !manager.undo();
//            //System.out.println(canvas.getDrawing());
//            assert manager.execute(command1);
//            //       System.out.println(canvas.getDrawing());
//            assert !manager.redo();
//            assert manager.undo();
//            //     System.out.println(canvas.getDrawing());
//            assert !manager.undo();
//            assert manager.redo();
//            assert !manager.redo();
//            //     System.out.println(canvas.getDrawing());
//        }
//        {
//            OverdrawAnalyzer canvas2 = new OverdrawAnalyzer(5, 4);
//            canvas2.drawPixel(0, 0, 'Z');
//            canvas2.drawPixel(1, 2, 'b');
//            canvas2.drawPixel(0, 1, 'c');
//            DrawPixelCommand command1 = new DrawPixelCommand(2, 3, 'A');
//            //System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//            //System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//            //System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//            CommandHistoryManager manager = new CommandHistoryManager(canvas2);
//            assert !manager.canRedo();
//            assert !manager.canUndo();
//            assert !manager.redo();
//            assert !manager.undo();
//            //System.out.println(canvas.getDrawing());
//            assert manager.execute(command1);
//            //       System.out.println(canvas.getDrawing());
//            assert !manager.redo();
//            assert manager.undo();
//            //     System.out.println(canvas.getDrawing());
//            assert !manager.undo();
//            assert manager.redo();
//            assert !manager.redo();
//            //     System.out.println(canvas.getDrawing());
//            assert canvas2.getOverdrawCount(2, 3) == 3;
//            assert canvas2.getOverdrawCount() == 6;
//            ClearCommand command2 = new ClearCommand();
//            assert command2.execute(canvas2);
//            //System.out.println(canvas.getDrawing());
//            assert command2.undo();
//            //System.out.println(canvas.getDrawing());
//            assert command2.redo();
//            assert !command2.redo();
//            //System.out.println(canvas.getDrawing());
//            assert command2.undo();
//            assert !command2.undo();
//            assert command2.redo();
//        }
//        {
//            OverdrawAnalyzer can2 = new OverdrawAnalyzer(5, 4);
//            can2.drawPixel(0, 0, 'Z');
//            can2.drawPixel(1, 2, 'b');
//            can2.drawPixel(0, 1, 'c');
//            DrawPixelCommand command1 = new DrawPixelCommand(2, 3, 'A');
//            //System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//            //System.out.println(canvas.getDrawing());
//            assert !command1.redo();
//            //System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//            CommandHistoryManager manager = new CommandHistoryManager(can2);
//            assert !manager.canRedo();
//            assert !manager.canUndo();
//            assert !manager.redo();
//            assert !manager.undo();
//            //System.out.println(canvas.getDrawing());
//            assert manager.execute(command1);
//            //       System.out.println(canvas.getDrawing());
//            assert !manager.redo();
//            assert manager.undo();
//            //     System.out.println(canvas.getDrawing());
//            assert !manager.undo();
//            assert manager.redo();
//            assert !manager.redo();
//            manager.undo();
//            can2.drawPixel(3, 3, '9');
//            assert !manager.redo();
//            assert !command1.redo();
//            ClearCommand command2 = new ClearCommand();
//            assert command2.execute(can2);
//            //System.out.println(canvas.getDrawing());
//            assert command2.undo();
//            //System.out.println(canvas.getDrawing());
//            assert command2.redo();
//            assert !command2.redo();
//            //System.out.println(canvas.getDrawing());
//            assert command2.undo();
//            assert !command2.undo();
//            assert command2.redo();
//        }
    }
}
