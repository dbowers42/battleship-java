package battleship;

import battleship.components.Board;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    private Container container;
    private Board playerBoard = new Board();
    private Board computerBoard = new Board();
    private Panel mainPanel = new Panel();

    public Application() {
        container = getContentPane();
        initializeComponents();
    }

    private void initializeComponents() {
        mainPanel.add(playerBoard);
        mainPanel.add(computerBoard);
        add(mainPanel);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.setSize(830, 430);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
