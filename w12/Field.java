import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Field {
    private int width;
    private int height;
    private Animal[][] field;

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
        field = new Animal[height][width];
    }

    public void clear() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                field[row][col] = null;
            }
        }
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public void place(Animal animal, Location location) {
        field[location.getRow()][location.getCol()] = animal;
    }

    public Animal getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public Animal getObjectAt(int row, int col) {
        return field[row][col];
    }

    public List<Location> getFreeAdjacentLocations(Location location) {
        List<Location> free = new LinkedList<>();
        List<Location> adjacent = adjacentLocations(location);
        for (Location next : adjacent) {
            if (getObjectAt(next) == null) {
                free.add(next);
            }
        }
        return free;
    }

    public Location freeAdjacentLocation(Location location) {
        List<Location> free = getFreeAdjacentLocations(location);
        if (free.size() > 0) {
            return free.get(Randomizer.nextInt(free.size()));
        } else {
            return null;
        }
    }

    private List<Location> adjacentLocations(Location location) {
        List<Location> locations = new LinkedList<>();
        int row = location.getRow();
        int col = location.getCol();
        for (int roffset = -1; roffset <= 1; roffset++) {
            int nextRow = row + roffset;
            if (nextRow >= 0 && nextRow < height) {
                for (int coffset = -1; coffset <= 1; coffset++) {
                    int nextCol = col + coffset;
                    if ((nextCol >= 0 && nextCol < width) && (roffset != 0 || coffset != 0)) {
                        locations.add(new Location(nextRow, nextCol));
                    }
                }
            }
        }
        return locations;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}