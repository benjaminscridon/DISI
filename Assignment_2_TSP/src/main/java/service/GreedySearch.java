package service;

import model.Node;
import model.TspBuilder;
import model.TspProblem;
import model.TspResult;

import java.util.List;

/**
 * Created by Beniamin on 3/31/2017.
 */
public class GreedySearch {

    public TspResult computeSolution(TspProblem tspProblem, double[][] costs, Node startingNode) {
        long startTime = System.nanoTime();

        TspResult tspResult = new TspResult();
        TspBuilder.constructHeader(tspProblem, tspResult);
        List<Node> nodes = tspProblem.getNodes();

        startingNode.setVisited(1);
        tspResult.getNodes().add(startingNode);
        Node currentNode = startingNode;

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
        tspResult.getNodes().add(startingNode);
        tspResult.setCost(tspResult.getCost() + costs[currentNode.getIndex()][startingNode.getIndex()]);

        long stopTime = System.nanoTime();
        tspResult.setExecutionTime(stopTime - startTime);

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
        // System.out.println("best cost:= " + bestCost);
        return nodes.get(nextNodeIndex);
    }
}
