package service;

import model.Node;
import model.TspProblem;
import model.TspResult;
import util.Euclidian2D;
import util.FileReader;

import java.util.List;

/**
 * Created by Beniamin on 3/31/2017.
 */
public class GreedySearch {

    public static void main(String[] args) {
        String filename = "src/main/resources/input/eil51.tsp";
        TspProblem tspProblem = FileReader.readFromFile(filename);
        System.out.println(tspProblem.toString());


        GreedySearch greedySearch = new GreedySearch();
        TspResult tspResult = greedySearch.computeSolution(tspProblem, Euclidian2D.computeAllDistances(tspProblem));
        System.out.println(tspResult.toString());
    }

    public TspResult computeSolution(TspProblem tspProblem, double[][] costs) {
        TspResult tspResult = new TspResult();
        List<Node> nodes = tspProblem.getNodes();

        Node currentNode = tspProblem.getNodes().get(1);
        currentNode.setVisited(1);
        tspResult.getNodes().add(currentNode);

        int counter = 1;
        while (counter < nodes.size() - 1) {
            Node nextNode = findNextNode(currentNode, nodes, costs);
            nextNode.setVisited(1);

            tspResult.getNodes().add(nextNode);
            tspResult.setCost(tspResult.getCost() + costs[currentNode.getIndex()][nextNode.getIndex()]);

            currentNode = nextNode;
            counter++;
        }

        // return to first node
        tspResult.getNodes().add(nodes.get(1));
        tspResult.setCost(tspResult.getCost() + costs[currentNode.getIndex()][1]);

        return tspResult;
    }


    private Node findNextNode(Node currenNode, List<Node> nodes, double[][] costs) {
        int currentNodeIndex = currenNode.getIndex();
        int nextNodeIndex = 0;
        double bestCost = Double.MAX_VALUE;

        for (int j = 1; j < nodes.size(); j++) {
            if (costs[currentNodeIndex][j] < bestCost && nodes.get(j).getVisited() == 0) {
                nextNodeIndex = j;
                bestCost = costs[currenNode.getIndex()][j];
            }

        }
        System.out.println("best cost:= " + bestCost);
        return nodes.get(nextNodeIndex);
    }
}
