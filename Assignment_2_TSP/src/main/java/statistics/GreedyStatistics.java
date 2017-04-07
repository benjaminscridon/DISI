package statistics;

import model.InputFilesEnum;
import model.TspProblem;
import model.TspResult;
import service.GreedySearch;
import util.Euclidian2D;
import util.FileReader;
import util.FileWriter;

/**
 * Created by Beniamin on 4/4/2017.
 */
public class GreedyStatistics {

    public static final String INPUT_FILES_PATH = "src/main/resources/input/";
    public static final String OUTPUT_FILES_PATH = "src/main/resources/results/greedy/";
    public static final String CURRENT_INPUT_FILE = InputFilesEnum.FILE_1.toString();

    public static void main(String[] args) {
        TspProblem tspProblem = FileReader.readFromFile(INPUT_FILES_PATH + CURRENT_INPUT_FILE);
        GreedySearch greedySearch = new GreedySearch();

        TspResult bestTspResult = new TspResult();
        bestTspResult.setCost(Double.MAX_VALUE);
        long executionTime = 0;

        for (int i = 1; i <= tspProblem.getDimension(); i++) {
            tspProblem = FileReader.readFromFile(INPUT_FILES_PATH + CURRENT_INPUT_FILE);
            TspResult tspResult = greedySearch.computeSolution(tspProblem, Euclidian2D.computeAllDistances(tspProblem), tspProblem.getNodes().get(i));

            executionTime += tspResult.getExecutionTime();

            if (tspResult.getCost() < bestTspResult.getCost()) {
                bestTspResult = tspResult;
            }
        }

        bestTspResult.setExecutionTime(executionTime / tspProblem.getDimension());
        FileWriter.writeToFile(OUTPUT_FILES_PATH + "result-" + CURRENT_INPUT_FILE, bestTspResult.toString());
    }
}
