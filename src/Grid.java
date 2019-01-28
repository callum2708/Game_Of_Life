import java.util.Random;

public class Grid {
    private Cell[][] grid;
    private Random random  = new Random();

    Grid(int rows, int columns){
        grid = new Cell[rows][columns];
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = (random.nextInt(2) == 0) ? Cell.Dead : Cell.Alive;
            }
        }
    }

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
