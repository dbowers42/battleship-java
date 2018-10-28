package battleship;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final String CLEAR = "\033[H\033[2J";
    private static final String OCCUPIED = " B ";
    private static final String HIT = " X ";
    private static final String MISS = " o ";
    private static final String SUNK = " * ";
    private static final String EMPTY = " ~ ";
    private static final String HEADERS = "   A  B  C  D  E  F  G  H  I  J";

    private List<Boat> boats = new ArrayList();

    private boolean reveal = false;

    private int occupiedCount = 0;

    private CellState[][] cells = new CellState[10][10];

    Board() {
        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                cells[row - 1][col - 1] = CellState.Empty;
            }
        }
    }

    public void addBoard(Boat boat) {
        this.boats.add(boat);
    }

    public boolean isReveal() {
        return reveal;
    }

    public void setReveal(boolean reveal) {
        this.reveal = reveal;
    }



    void plot(char col, int row, CellState state) {
        if (state == CellState.Occupied) {
            occupiedCount++;
        }

        cells[col - 65][row - 1] = state;
    }

    CellState getState(char col, int row) {
        return cells[col - 65][row - 1];
    }

    void guess(char col, int row) {
        if (cells[col - 65][row - 1] == CellState.Occupied) {
            cells[col - 65][row - 1] = CellState.Hit;
        } else {
            cells[col - 65][row - 1] = CellState.Missed;
        }
    }

    boolean gameOver() {
        return occupiedCount == 0;
    }

    void render() {
        // Clear screen
        System.out.print(CLEAR);

        System.out.println(HEADERS);
        for (int row = 1; row <= 10; row++) {
            System.out.printf("%02d", row);

            for (int col = 1; col <= 10; col++) {
                switch (cells[col - 1][row - 1]) {
                    case Hit:
                        occupiedCount--;
                        System.out.print(HIT);
                        break;
                    case Missed:
                        System.out.print(MISS);
                        break;
                    case Occupied:
                        if (reveal) {
                            System.out.print(OCCUPIED);
                        } else {
                            System.out.print(EMPTY);
                        }
                        break;
                    case Sunk:
                        System.out.print(SUNK);
                        break;
                    default:
                        System.out.print(EMPTY);
                        break;
                }
            }
            System.out.println();
        }
    }
}
