package statistics;

import model.Backpack;
import model.BackpackProblem;
import service.RandomSearch;

/**
 * @author Beniamin Scridon
 */
public class RandomSearchStatistics {

    private static final int K = 1000000;
    private static final String INPUT = "src/main/resources/input/rucsac-200.txt";
    private static String OUTPUT = "src/main/resources/results/random/rucsac-200/k-" + K + ".txt";
    private static String REMARKS = "src/main/resources/results/random/rucsac-200/k-" + K + "-remarks.txt";

    public static void main(String[] args) {
        long executionTimeAverage = 0;
        long valueAverage = 0;
        long bestValue = 0;

        StringBuilder result = new StringBuilder();

        result.append("================== Backpack PROBLEM - INPUT ====================\n");
        BackpackProblem problem = util.FileReader.readFromFile(INPUT);
        result.append(problem.prettyPrint());

        for (int k = 1; k <= K; k++) {
            result.append("\n=================== Backpack SOLUTION " + k + "=============================\n");

            long startTime = System.nanoTime();
            BackpackProblem myProblem = util.FileReader.readFromFile(INPUT);
            Backpack backpack = new RandomSearch().computeSolution(myProblem);
            long stopTime = System.nanoTime();

            result.append(backpack.prettyPrint());
            result.append("\nExecution Time:" + (stopTime - startTime) + " ns");

            executionTimeAverage += stopTime - startTime;
            valueAverage += backpack.getValue();

            if (bestValue < backpack.getValue()) {
                bestValue = backpack.getValue();
            }
        }

        util.FileWriter.writeToFile(OUTPUT, result.toString());

        StringBuilder remarks = new StringBuilder();
        remarks.append("Best value: " + bestValue);
        remarks.append("\nSolutions Average: " + (valueAverage / K));
        remarks.append("\nExecution Time Average: " + (executionTimeAverage / 1000000) + " ms");

        util.FileWriter.writeToFile(REMARKS, remarks.toString());
    }
}
