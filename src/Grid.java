import java.util.Random;

/**
 *  A class representing a grid of Cell objects
 */
public class Grid {
    private Cell[][] grid;
    private int numRows, numColumns;
    private Random random  = new Random();

    /**
     * Constructor that builds a Grid object of a secified numeber of rows and columns
     * @param rows      The desired number of rows
     * @param columns   The desired number of columns
     */
    Grid(int rows, int columns){
        grid = new Cell[rows][columns];
        numRows = rows;
        numColumns = columns;
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
//                grid[i][j] = (random.nextInt(2) == 0) ? Cell.Dead : Cell.Alive;
                grid[i][j] = Cell.Dead;
            }
        }
        grid[5][5] = Cell.Alive;
        grid[5][4] = Cell.Alive;
        grid[5][6] = Cell.Alive;
    }

    /**
     * Counts the number of neighbours that are alive for a Cell at a specified row and column
     * @param row       The row number of the Cell being checked, indexing starts at 0
     * @param column    The row number of the Cell being checked, indexing starts at 0
     * @return The number of alive neighbours
     */
    public int numberOfAliveNeighbours(int row, int column){
        int numberAliveNeighbours = 0;

        //add the value of each sorrounding neighbour
        //TODO: convert to loop
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
     * Sets a cell at a give row and column to a given Cell state
     * @param row       The row number of the cell being set
     * @param column    The column number of the cell being set
     * @param cell      The state that the cell is being set to (Alive or Dead)
     */
    public void setCell(int row, int column, Cell cell){
        grid[row][column] = cell;
    }

    /**
     * Checks if a given cell is alive
     * @param row       The row number of the cell being checked
     * @param column    The column number of the cell being checked
     * @return          A boolean representing whether or not the cell is alive
     */
    public boolean isCellAlive(int row, int column){
        return grid[row][column] == Cell.Alive;
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
        System.out.println("\n\n" + numberOfAliveNeighbours(5,4));
    }

    public int numberOfRows(){
        return numRows;
    }

    public int numberOfColumns(){
        return numColumns;
    }
}
