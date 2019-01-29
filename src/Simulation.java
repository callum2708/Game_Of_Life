/**
 * Represents a simulation of the game of life
 */
public class Simulation {
    private Grid currentGrid;
    private Grid nextGrid;

    /**
     * Creates a Simulation with two grids
     * that are used to carry out the simulation
     * @param rows     The number of rows in the simulation
     * @param columns  The number of columns in the simulation
     */
    Simulation(int rows, int columns){
        //create two grids, one for the current time step,
        //and oen for the time step being computed
        currentGrid = new Grid(rows, columns);
        nextGrid = new Grid(rows, columns);
    }

    /**
     * Starts the simulation which then runs indefinitely until stopped
     */
    public void start() throws InterruptedException{
        //infinite loop to run simulation util it is stopped
        while (true){
            currentGrid.print();
            //loop through the entire grid
            for (int row = 0; row < currentGrid.numberOfRows(); row++) {
                for (int column = 0; column < currentGrid.numberOfColumns(); column++) {
                    if(currentGrid.isCellAlive(row, column)){
                        evolveAliveCell(row, column);
                    } else {
                        evolveDeadCell(row, column);
                    }
                }
            }
            currentGrid = nextGrid;
            nextGrid = new Grid(currentGrid.numberOfRows(), currentGrid.numberOfColumns());
            Thread.sleep(1000);
        }
    }

    /**
     * Evolves a cell assuming it is alive
     * @param row       The row number of the cell being evolved
     * @param column    The column number of the cell being evolved
     */
    private void evolveAliveCell(int row, int column){
        int numberOfAliveNeighbours = currentGrid.numberOfAliveNeighbours(row, column);
        //consider the three cases
        if(numberOfAliveNeighbours < 2){  //underpopulation
            nextGrid.setCell(row, column, Cell.Dead);
        } else if (numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3) {  //survival
            nextGrid.setCell(row, column, Cell.Alive);
        } else if (numberOfAliveNeighbours > 3){    //overcrowding
            nextGrid.setCell(row, column, Cell.Dead);
        }
    }


    /**
     * Evolves a cell assuming it is dead
     * @param row       The row number of the cell being evolved
     * @param column    The column number of the cell being evolved
     */
    private void evolveDeadCell(int row, int column){
        int numberOfAliveNeighbours = currentGrid.numberOfAliveNeighbours(row, column);
        //check if the cell has three neighbouring alive cells
        if(numberOfAliveNeighbours == 3){
            nextGrid.setCell(row, column, Cell.Alive);
        }
    }
}
