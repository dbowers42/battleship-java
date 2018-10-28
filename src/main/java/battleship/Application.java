package battleship;

import battleship.gui.MainWindow;

import javax.swing.*;
import java.util.Scanner;

public class Application {
    static void console() {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        board.plot('B', 3, CellState.Occupied);
        board.plot('B', 4, CellState.Occupied);
        board.plot('B', 5, CellState.Occupied);
        board.plot('B', 6, CellState.Occupied);
        board.plot('B', 7, CellState.Occupied);

        board.plot('I', 1, CellState.Occupied);
        board.plot('J', 1, CellState.Occupied);

        board.plot('D', 4, CellState.Occupied);
        board.plot('E', 4, CellState.Occupied);
        board.plot('F', 4, CellState.Occupied);
        board.plot('G', 4, CellState.Occupied);

        board.plot('B', 10, CellState.Occupied);
        board.plot('C', 10, CellState.Occupied);
        board.plot('D', 10, CellState.Occupied);

        board.plot('H', 6, CellState.Occupied);
        board.plot('H', 7, CellState.Occupied);
        board.plot('H', 8, CellState.Occupied);

        board.setReveal(true);
        board.render();

        while(!board.gameOver()) {
            System.out.print("Enter guess:");
            String col = scanner.next();
            String row = scanner.next();

            board.guess(col.toUpperCase().charAt(0), Integer.parseInt(row));
            board.render();
        }

        System.out.println("Game over");
    }

    public static void main(String[] args) {
        MainWindow win = new MainWindow();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
}
