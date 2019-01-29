import java.util.Arrays;

public class Main {
    public static void main(String[] args)  throws InterruptedException{
        Simulation simulation = new Simulation(Integer.parseInt(args[1]), Integer.parseInt(args[1]));
        simulation.start();
    }
}
