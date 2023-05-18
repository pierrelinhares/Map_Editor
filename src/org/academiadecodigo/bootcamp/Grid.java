package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Cell;

public class Grid {

    public static final int CELL_SIZE = 20;
    public static final int PADDING = 10;
    private int rows;
    private int cols;

    private Cell[][] cells;

    public Grid(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;

        cells = new Cell[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public void stringToGrid(String grid) {

        int index = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                Cell cell = cells[row][col];

                if (grid.charAt(index) == '0') {
                    cell.erase();
                } else {
                    cell.paint();
                }

                index++;
            }
            index++; // skip "\n" on each line
        }

    }

    public void clear() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].erase();
            }
        }
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                strBuilder.append(cells[row][col]);
            }
            strBuilder.append("\n");
        }

        return strBuilder.toString();

    }
}
