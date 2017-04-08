package statistics;

import model.InputFilesEnum;
import model.TspProblem;
import service.ExhaustiveSearch;
import util.FileReader;


/**
 * Created by Beniamin on 4/8/2017.
 */
public class ExhaustiveStatistics {
    public static final String INPUT_FILES_PATH = "src/main/resources/input/";
    public static final String OUTPUT_FILES_PATH = "src/main/resources/results/exhaustive/";
    public static final String CURRENT_INPUT_FILE = InputFilesEnum.FILE_1.toString();

    public static void main(String[] args) {
        TspProblem tspProblem = FileReader.readFromFile(INPUT_FILES_PATH + CURRENT_INPUT_FILE);
        int numberOfCities = tspProblem.getDimension();

        int[] P = new int[numberOfCities];
        for (int i = 0; i < numberOfCities; i++) {
            P[i] = i + 1;
        }

        new ExhaustiveSearch(OUTPUT_FILES_PATH + "result-" + CURRENT_INPUT_FILE).generate(numberOfCities, P);
    }
}
