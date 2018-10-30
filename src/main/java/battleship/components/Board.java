package battleship.components;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {
    private BoardCell[][] cells;
    private final int maxOccupy = 15;

    private void randomBoats() {
        randomBoat(2, Color.RED);
        randomBoat(3, Color.GREEN);
        randomBoat(3, Color.YELLOW);
        randomBoat(4, Color.BLUE);
        randomBoat(5, Color.WHITE);


//        drawBoat(0, 0, 0, 1, Color.RED);
//        drawBoat(1, 0, 1, 2, Color.GREEN);
//        drawBoat(2, 0, 2, 2, Color.YELLOW);
//        drawBoat(3, 0, 3, 3, Color.BLUE);
//        drawBoat(4, 0, 4, 4, Color.WHITE);
    }

    private boolean hasCollisions() {
        int occupiedCount = 0;

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (cells[row][col].getState() == BoardCell.State.Occupied) {
                    occupiedCount++;
                }
            }
        }

        System.out.println(occupiedCount);

        return occupiedCount != maxOccupy;
    }

    private void clearBoats() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                cells[row][col].clear();
            }
        }
    }

    private void randomBoat(int length, Color color) {
        Boat boat;
        Random rand = new Random();
        boolean collides;

        do {
            BoardCell.Orientation orientation;

            if (rand.nextInt(10) % 2 == 0) {
                orientation = BoardCell.Orientation.Horizontal;
            } else {
                orientation = BoardCell.Orientation.Vertical;
            }

            int row, col;

            collides = false;

            if (orientation == BoardCell.Orientation.Horizontal) {
                row = rand.nextInt(10);
                col = rand.nextInt(10 - length);
                boat = new Boat(row, col, row, col + length - 1, color);

            } else {
                row = rand.nextInt(10 - length);
                col = rand.nextInt(10);
                boat = new Boat(row, col, row + length - 1, col, color);

                for(Location location: boat.getLocations()) {
                    if(cells[location.getRow()][location.getColumn()].getState() == BoardCell.State.Occupied) {
                        collides = true;
                        break;
                    }
                }
            }
        }
        while (collides);

        addBoat(boat);
    }

    public Board() {
        GridLayout layout = new GridLayout(10, 10);
        setLayout(layout);

        cells = new BoardCell[10][10];

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                BoardCell cell = new BoardCell();
                cells[row][col] = cell;
                add(cell);
            }
        }

        randomBoats();

        setSize(400, 400);
    }


    public void addBoat(Boat boat) {
        BoardCell.Orientation orientation;

        if (boat.getStart().getRow() == boat.getStop().getRow()) {
            orientation = BoardCell.Orientation.Horizontal;
        } else {
            orientation = BoardCell.Orientation.Vertical;
        }

        for (Location location : boat.getLocations()) {
            BoardCell cell = cells[location.getRow()][location.getColumn()];
            cell.setState(BoardCell.State.Occupied);
            cell.setOrientation(orientation);
            cell.setBoatColor(boat.getBoatColor());
        }

        BoardCell start = cells[boat.getStart().getRow()][boat.getStart().getColumn()];
        BoardCell stop = cells[boat.getStop().getRow()][boat.getStop().getColumn()];

        if (orientation == BoardCell.Orientation.Horizontal) {
            start.setOrientation(BoardCell.Orientation.Left);
            stop.setOrientation(BoardCell.Orientation.Right);

        } else {
            start.setOrientation(BoardCell.Orientation.Top);
            stop.setOrientation(BoardCell.Orientation.Bottom);
        }

        start.setBoatColor(boat.getBoatColor());
        stop.setBoatColor(boat.getBoatColor());
    }
}
