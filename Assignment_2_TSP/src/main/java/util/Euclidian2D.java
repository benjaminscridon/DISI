package util;

import model.Node;
import model.TspProblem;

import java.util.List;

/**
 * Created by Beniamin on 3/31/2017.
 */
public class Euclidian2D {

    public static double[][] computeAllDistances(TspProblem tspProblem) {
        int numberOfNodes = tspProblem.getDimension();
        double[][] costs = new double[numberOfNodes + 5][numberOfNodes + 5];

        List<Node> nodes = tspProblem.getNodes();

        for (int i = 1; i <= numberOfNodes; i++) {
            for (int j = 1; j <= numberOfNodes; j++) {
                costs[i][j] = computeDistanceBetweenTwoNodes(nodes.get(i), nodes.get(j));
                System.out.println("EC2 (" + i + "," + j + ") = " + costs[i][j]);
            }
        }

        return costs;
    }

    public static double computeDistanceBetweenTwoNodes(Node node1, Node node2) {
        double term1 = node1.getX() - node2.getX();
        double term2 = node1.getY() - node2.getY();

        return Math.sqrt(Math.pow(term1, 2) + Math.pow(term2, 2));
    }
}
