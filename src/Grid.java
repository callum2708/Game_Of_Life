import java.util.Random;

/**
 *  A class representing a grid of Cell objects
 */
public class Grid {
    private Cell[][] grid;
    private Random random  = new Random();

    /**
     * Constructor that builds a Grid object of a secified numeber of rows and columns
     * @param rows      The desired number of rows
     * @param columns   The desired number of columns
     */
    Grid(int rows, int columns){
        grid = new Cell[rows][columns];
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = (random.nextInt(2) == 0) ? Cell.Dead : Cell.Alive;
            }
        }
    }

    /**
     * Counts the number of neighbours that are alive for a Cell at a specified row and column
     * @param row       The row number of the Cell being checked, indexing starts at 0
     * @param column    The row number of the Cell being checked, indexing starts at 0
     * @return The number of alive neighbours
     */
    private int numberOfAliveNeighbours(int row, int column){
        int numberAliveNeighbours = 0;

        //add the value of each sorrounding neighbour. Not done in a loop as
        // it looks cleaner due to the need to manage edge cases
        if(row != 0)
            numberAliveNeighbours += grid[row - 1][column    ].ordinal();
        if(row != grid.length - 1)
            numberAliveNeighbours += grid[row + 1][column    ].ordinal();
        if(column != 0)
            numberAliveNeighbours += grid[row    ][column - 1].ordinal();
        if(column != grid[0].length - 1)
            numberAliveNeighbours += grid[row    ][column + 1].ordinal();
        if(row != 0 &&  column != 0)
            numberAliveNeighbours += grid[row - 1][column - 1].ordinal();
        if(row != grid.length - 1 &&  column != grid[0].length - 1)
            numberAliveNeighbours += grid[row + 1][column + 1].ordinal();
        if(row != 0 &&  column != grid[0].length - 1)
            numberAliveNeighbours += grid[row - 1][column + 1].ordinal();
        if(row != grid.length - 1 &&  column != 0)
            numberAliveNeighbours += grid[row + 1][column - 1].ordinal();

        return numberAliveNeighbours;
    }

    /**
     * Prints the grid object in a readable format
     */
    public void print(){
        for(Cell[] cells : grid){
            for(Cell cell : cells){
                System.out.print(cell.ordinal() + " | ");
            }
            System.out.println("");
        }
    }

    public Cell[][] getCells(){
        return grid;
    }
}
