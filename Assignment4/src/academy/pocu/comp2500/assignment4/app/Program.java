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

public class Program {

    public static void main(String[] args) {
        OverdrawAnalyzer canvas = new OverdrawAnalyzer(30, 30);

        {
            var fv = new FillVerticalLineCommand(21, '8');
            var fh = new FillHorizontalLineCommand(21, '7');
            fv.execute(canvas);
            System.out.println(canvas.getDrawing());
            fh.execute(canvas);
            System.out.println(canvas.getDrawing());
            fv.undo();
            System.out.println(canvas.getDrawing());
        }
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

//        {
//            var manager = new CommandHistoryManager(canvas);
//            var fv = new FillVerticalLineCommand(21, '8');
//            manager.execute(fv);
//            var ip = new IncreasePixelCommand(21, 2);
//            manager.execute(ip);
//            System.out.println(canvas.getOverdrawCount());
//            System.out.println(canvas.getOverdrawCount(21, 21));
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
////        {
//            var manager = new CommandHistoryManager(canvas);
//            manager.redo();
//            manager.redo();
//
//            ICommand upperCommand = new ToUppercaseCommand(21, 8);
//            manager.execute(upperCommand);
//            System.out.println(canvas.getDrawing());
//            ICommand drawPixel = new DrawPixelCommand(14, 10, 'v');
//
//            manager.execute(drawPixel);
//            System.out.println(canvas.getDrawing());
//            manager.redo();
//            manager.undo();
//            manager.redo();
//
//            assert manager.undo();
//
//            System.out.println(canvas.getDrawing());
//            ICommand fillh = new FillHorizontalLineCommand(2, 'a');
//            manager.execute(fillh);
//            ICommand decrease = new DecreasePixelCommand(23, 17);
//            manager.execute(decrease);
//
//            System.out.println(canvas.getDrawing());
//            manager.undo();
//            System.out.println(canvas.getDrawing());
//            assert manager.redo();
//            System.out.println(canvas.getDrawing());
//            assert !manager.redo();
//            manager.redo();
//            manager.redo();
//        }
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
//            assert command1.undo();
//            System.out.println(canvas.getDrawing());
//            assert !command1.undo();
//
//            assert command1.redo();
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

    }
}
