package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Cell;
import org.academiadecodigo.bootcamp.grid.Cursor;
import org.academiadecodigo.bootcamp.utils.FileManager;

public class MapEditor {

    private Grid grid;
    private Cursor cursor;
    private boolean painting;

    public MapEditor(int rows, int cols) {
        grid = new Grid(rows, cols);
        cursor = new Cursor();
    }

    public void moveCursor(Cursor.Direction direction) {

        if (cursorOnEdge(direction)) {
            return;
        }

        switch (direction) {
            case UP:
                cursor.moveUp();
                break;
            case DOWN:
                cursor.moveDown();
                break;
            case LEFT:
                cursor.moveLeft();
                break;
            case RIGHT:
                cursor.moveRight();
                break;
        }

        if (painting) {
            paintCell();
        }
    }

    public void paintCell() {
        Cell cell = grid.getCell(cursor.getRow(), cursor.getCol());
        if (cell.isPainted()) {
            cell.erase();
        } else {
            cell.paint();
        }
    }

    public void clear() {
        grid.clear();
    }

    public void load() {
        grid.stringToGrid(FileManager.readFile());
    }

    public void save() {
        FileManager.writeToFile(grid.toString());
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }

    private boolean cursorOnEdge(Cursor.Direction direction) {
        return direction == Cursor.Direction.UP && cursor.getRow() == 0 ||
                direction == Cursor.Direction.DOWN && cursor.getRow() == grid.getRows() - 1 ||
                direction == Cursor.Direction.LEFT && cursor.getCol() == 0 ||
                direction == Cursor.Direction.RIGHT && cursor.getCol() == grid.getCols() - 1;
    }

}
