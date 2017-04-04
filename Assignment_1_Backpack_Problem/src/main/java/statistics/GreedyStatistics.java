package statistics;

import model.Backpack;
import model.BackpackProblem;
import service.GreedySearch;
import util.FileReader;
import util.FileWriter;

/**
 * Created by Beniamin on 3/26/2017.
 */
public class GreedyStatistics {

    private static final String INPUT = "src/main/resources/input/rucsac-200.txt";
    private static final String OUTPUT = "src/main/resources/results/greedy/metric-maximum-value-weight-ratio/";

    public static void main(String[] args) {
        long startTime = 0;
        long stopTime = 0;
        String result = "";
        BackpackProblem problem = FileReader.readFromFile(INPUT);

        startTime = System.nanoTime();
        Backpack solution = new GreedySearch().computeSolution(problem);
        stopTime = System.nanoTime();

        result += solution.prettyPrint();
        result += "\nExecution Time:" + (stopTime - startTime) + " ns";

        FileWriter.writeToFile(OUTPUT + "result-rucsac-200.txt", result);
    }

}
