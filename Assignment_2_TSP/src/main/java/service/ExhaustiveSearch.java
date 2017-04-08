package service;

import util.FileWriter;

/**
 * Created by Beniamin on 4/8/2017.
 */
public class ExhaustiveSearch {
    private static int counter = 1;
    private String resultFileName;

    public ExhaustiveSearch(String resultFileName) {
        this.resultFileName = resultFileName;
    }

    public void generate(int n, int[] P) {
        if (n == 1) {
            print(P);
        } else {
            for (int i = 0; i < n - 1; i++) {
                generate(n - 1, P);

                if (n % 2 == 0) {
                    int var = P[i];
                    P[i] = P[n - 1];
                    P[n - 1] = var;
                } else {
                    int var2 = P[0];
                    P[0] = P[n - 1];
                    P[n - 1] = var2;
                }
            }

            generate(n - 1, P);
        }
    }

    private void print(int[] P) {
        String line = "S[" + counter + "] : ";

        for (int i = 0; i < P.length; i++) {
            line += P[i] + "  ";
        }

        counter++;
        line += "\n";

        FileWriter.writeToFile(resultFileName, line);
    }
}
