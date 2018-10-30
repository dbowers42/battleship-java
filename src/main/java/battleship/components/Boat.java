package battleship.components;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boat {
    private List<Location> locations = new ArrayList<>();
    private List<Location> hits = new ArrayList<>();
    private Location start;
    private Location stop;
    private Color boatColor;

    public Boat(int row1, int col1, int row2, int col2, Color color) {
        this(new Location(row1, col1), new Location(row2, col2), color);
    }

    public Boat(Location l1, Location l2, Color color) {
        int row1 = l1.getRow();
        int col1 = l1.getColumn();
        int row2 = l2.getRow();
        int col2 = l2.getColumn();

        start = l1;
        stop = l2;

        boatColor = color;

        if (row1 == row2) {
            for (int col = col1; col < col2; col++) {
                locations.add(new Location(row1, col));
            }
        } else {
            for (int row = row1; row < row2; row++) {
                locations.add(new Location(row, col1));
            }
        }
    }

    public Color getBoatColor() {
        return boatColor;
    }

    public Location getStart() {
        return start;
    }

    public Location getStop() {
        return stop;
    }

    public List<Location> getLocations() {
        return Collections.unmodifiableList(locations);
    }

    void addHit(Location location) {
        hits.add(location);
    }


}
