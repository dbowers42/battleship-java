package battleship.gui;

import battleship.CellState;

import javax.swing.*;
import java.awt.*;

public class BoardComponent extends JPanel {
    private CellComponent[][] cells;


    public BoardComponent() {
        GridLayout layout = new GridLayout(10, 10);
        setLayout(layout);

        cells = new CellComponent[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                CellComponent cell = new CellComponent();
                cells[row][col] = cell;
                add(cell);
            }
        }

        // Horizontal
        cells[0][0].setState(CellState.Occupied);
        cells[0][0].setOrientation(Orientation.Left);

        cells[0][1].setState(CellState.Occupied);
        cells[0][1].setOrientation(Orientation.Horizontal);

        cells[0][2].setState(CellState.Occupied);
        cells[0][2].setOrientation(Orientation.Right);




        // Vertical
        cells[3][5].setState(CellState.Occupied);
        cells[3][5].setOrientation(Orientation.Top);

        cells[4][5].setState(CellState.Occupied);
        cells[4][5].setOrientation(Orientation.Vertical);

        cells[5][5].setState(CellState.Occupied);
        cells[5][5].setOrientation(Orientation.Bottom);



        // Long boat
        cells[8][4].setState(CellState.Occupied);
        cells[8][4].setOrientation(Orientation.Left);

        cells[8][5].setState(CellState.Occupied);
        cells[8][5].setOrientation(Orientation.Horizontal);

        cells[8][6].setState(CellState.Occupied);
        cells[8][6].setOrientation(Orientation.Horizontal);

        cells[8][7].setState(CellState.Occupied);
        cells[8][7].setOrientation(Orientation.Horizontal);

        cells[8][8].setState(CellState.Occupied);
        cells[8][8].setOrientation(Orientation.Right);



        setSize(400, 400);
    }


}
