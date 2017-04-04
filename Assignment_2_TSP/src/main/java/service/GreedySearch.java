package service;

import model.Node;
import model.TspProblem;
import model.TspResult;
import util.Euclidian2D;
import util.FileReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beniamin on 3/31/2017.
 */
public class GreedySearch {

    public static void main(String[] args) {
        String filename = "src/main/resources/input/eil51.tsp";
        TspProblem tspProblem = FileReader.readFromFile(filename);
        double[][] costs = Euclidian2D.computeAllDistances(tspProblem);

        // System.out.println(findNextNode(tspProblem.getNodes().get(1), tspProblem.getNodes(), costs));
        System.out.println(computeSolution(tspProblem));
    }

    public static TspResult computeSolution(TspProblem tspProblem) {
        TspResult tspResult = new TspResult();
        tspResult.setNodes(new ArrayList<Node>());


        //1 .1 costs
        double[][] costs = Euclidian2D.computeAllDistances(tspProblem);

        // 1. iau primul element si caut nodul vecin cu costul cel mai mic
        Node currentNode = tspProblem.getNodes().get(1);
        currentNode.setVisited(1);
        tspResult.getNodes().add(currentNode);
        int counter = 1;

        while (counter < tspProblem.getNodes().size() - 1) {
            //2. pun vecinul in lista de noduri tspResult
            Node nextNode = findNextNode(currentNode, tspProblem.getNodes(), costs);
            tspResult.getNodes().add(nextNode);
            nextNode.setVisited(1);
            currentNode = nextNode;
            counter++;
        }

        return tspResult;
    }

    public static int counterr = 1;

    public static Node findNextNode(Node currenNode, List<Node> nodes, double[][] costs) {
        int nextNodeIndex = 1;
        double bestCost = 0.0;

        for (int j = 1; j <= nodes.size(); j++) {
            if (costs[currenNode.getIndex()][j] > bestCost && nodes.get(j).getVisited() == 0) {
                nextNodeIndex = j;
                bestCost = costs[currenNode.getIndex()][j];
            }

        }
        System.out.println(counterr + " NEXT NODE = " + nodes.get(nextNodeIndex));
        counterr++;
        return nodes.get(nextNodeIndex);
    }
}
