package battleship.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private Container container;

    public MainWindow() {
        setSize(830, 430);
        container = getContentPane();


        initializeComponents();
    }


    private void initializeComponents() {
        BoardComponent b1 = new BoardComponent();
        BoardComponent b2 = new BoardComponent();
        JPanel p = new JPanel();

        p.add(b1);
        p.add(b2);
        container.add(p);
    }


}
