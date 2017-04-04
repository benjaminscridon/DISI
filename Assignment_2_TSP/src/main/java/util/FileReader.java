package util;

import model.Node;
import model.TspProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Beniamin Scridon
 */
public class FileReader {

    public static TspProblem readFromFile(String fileName) {
        TspProblem tspProblem = new TspProblem();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            constructTspProblemHeader(tspProblem, reader);

            List<Node> nodes = new ArrayList<>();
            nodes.add(null); // nodes will start from inde 1

            String line = "";
            reader.readLine(); // jump

            while ((line = reader.readLine()) != null && line.length() != 0) {
                nodes.add(constructNode(line.split(" ")));
            }

            tspProblem.setNodes(nodes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tspProblem;
    }

    private static void constructTspProblemHeader(TspProblem tspProblem, BufferedReader reader) throws IOException {
        tspProblem.setName(getStringValue(reader.readLine()));
        tspProblem.setComment(getStringValue(reader.readLine()));
        tspProblem.setType(getStringValue(reader.readLine()));
        tspProblem.setDimension(getDimension(reader.readLine()));
        tspProblem.setEdgeWeightType(getStringValue(reader.readLine()));
    }

    private static Node constructNode(String[] input) {
        Node node = new Node();

        node.setIndex(Integer.parseInt(input[0]));
        node.setX(Integer.parseInt(input[1]));
        node.setY(Integer.parseInt(input[2]));

        return node;
    }

    public static String getStringValue(String input) {
        return input.split(":")[1].trim();
    }

    public static Integer getDimension(String input) {
        return new Integer(input.split(":")[1].trim());
    }
}
