package battleship.gui;

import battleship.CellState;

import javax.swing.*;
import java.awt.*;

public class CellComponent extends JPanel {
    private final int size = 40;
    private CellState state = CellState.Empty;
    private Orientation orientation = Orientation.None;
    private boolean hit = true;
    private boolean reveal = true;

    private final Color waterColor = new Color(58, 115, 255);
    private final Color gridColor = new Color(156, 233, 255);
    private final Color boatColor = Color.GRAY;
    public CellComponent() {
        setPreferredSize(new Dimension(40, 40));
    }

    private int convertX(int x) {
        return getWidth() / 2 + x;
    }

    private int convertY(int y) {
        return getHeight() / 2 - y;
    }

    public boolean isReveal() {
        return reveal;
    }

    public void setReveal(boolean reveal) {
        this.reveal = reveal;
    }

    public CellState getState() {
        return state;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    @Override
    public void paint(Graphics g) {
        setBackground(waterColor);
        g.setColor(waterColor);
        super.paint(g);

        if (reveal) {
            switch (orientation) {
                case Left:
                    drawLeft(g);
                    break;
                case Right:
                    drawRight(g);
                    break;
                case Top:
                    drawTop(g);
                    break;
                case Bottom:
                    drawBottom(g);
                    break;
                case Horizontal:
                    drawHorizontal(g);
                    break;
                case Vertical:
                    drawVertical(g);
                    break;
                default:
                    drawEmpty(g);
                    break;
            }
        } else {
            switch (state) {
                case Hit:
                    drawHit(g);
                    break;
                case Missed:
                    drawMiss(g);
                default:
                    drawEmpty(g);

            }
        }
    }

    private void drawBox(Graphics g, int x1, int y1, int x2, int y2) {
        x1 = convertX(x1);
        x2 = convertX(x2);
        y1 = convertY(y1);
        y2 = convertY(y2);

        g.drawLine(x1, y1, x2, y1);
        g.drawLine(x2, y1, x2, y2);
        g.drawLine(x2, y2, x1, y2);
        g.drawLine(x1, y2, x1, y1);

    }

    private void drawLeft(Graphics g) {
        Polygon polygon = new Polygon();

        polygon.addPoint(-15, 0);
        polygon.addPoint(0, 15);
        polygon.addPoint(20, 15);
        polygon.addPoint(20, -15);
        polygon.addPoint(0, -15);

        polygon.translate(20, 20);

        g.setColor(boatColor);

        g.fillPolygon(polygon);

        if (hit) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.black);
        }

        g.fillOval(convertX(0), convertY(5), 10, 10);

    }

    private void drawRight(Graphics g) {
        Polygon polygon = new Polygon();

        polygon.addPoint(15, 0);
        polygon.addPoint(0, 15);
        polygon.addPoint(-20, 15);
        polygon.addPoint(-20, -15);
        polygon.addPoint(0, -15);

        polygon.translate(20, 20);

        g.setColor(boatColor);

        g.fillPolygon(polygon);


        if (hit) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.black);
        }

        g.fillOval(convertX(-10), convertY(5), 10, 10);
    }

    private void drawTop(Graphics g) {
        Polygon polygon = new Polygon();

        polygon.addPoint(0, -15);
        polygon.addPoint(15, 0);
        polygon.addPoint(15, 20);
        polygon.addPoint(-15, 20);
        polygon.addPoint(-15, 0);

        polygon.translate(20, 20);

        g.setColor(boatColor);

        g.fillPolygon(polygon);

        if (hit) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.black);
        }

        g.fillOval(convertX(-5), convertY(0), 10, 10);
    }

    private void drawBottom(Graphics g) {
        Polygon polygon = new Polygon();

        polygon.addPoint(0, 15);
        polygon.addPoint(15, 0);
        polygon.addPoint(15, -20);
        polygon.addPoint(-15, -20);
        polygon.addPoint(-15, 0);

        polygon.translate(20, 20);

        g.setColor(boatColor);

        g.fillPolygon(polygon);

        if (hit) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.black);
        }

        g.fillOval(convertX(-5), convertY(5), 10, 10);
    }

    private void drawHorizontal(Graphics g) {
        g.setColor(boatColor);
        g.fillRect(0, 5, 40, 30);

        if (hit) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.black);
        }

        g.fillOval(15, 15, 10, 10);
    }

    private void drawVertical(Graphics g) {
        g.setColor(boatColor);
        g.fillRect(5, 0, 30, 40);

        if (hit) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.black);
        }

        g.fillOval(15, 15, 10, 10);
    }

    private void drawEmpty(Graphics g) {
        g.setColor(gridColor);
        drawBox(g, -20, -20, 19, 19);
    }

    private void drawHit(Graphics g) {
        g.setColor(Color.RED);
        drawBox(g, -20, -20, 19, 19);

        g.drawLine(0, 0, 40, 40);
        g.drawLine(0, 40, 40, 0);
    }

    private void drawMiss(Graphics g) {
        g.setColor(Color.WHITE);
        drawBox(g, -20, -20, 19, 19);

        g.drawLine(0, 0, 40, 40);
        g.drawLine(0, 40, 40, 0);
    }
}
