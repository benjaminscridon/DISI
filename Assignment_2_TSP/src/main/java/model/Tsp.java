package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beniamin on 3/31/2017.
 */
public class Tsp {

    private String name;
    private String comment;
    private String type;
    private int dimension;
    private String edgeWeightType;
    private List<Node> nodes;

    public Tsp() {
        nodes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public String getEdgeWeightType() {
        return edgeWeightType;
    }

    public void setEdgeWeightType(String edgeWeightType) {
        this.edgeWeightType = edgeWeightType;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("NAME : " + name + "\n");
        result.append("COMMENT : " + comment + "\n");
        result.append("TYPE : " + type + "\n");
        result.append("DIMENSION : " + dimension + "\n");
        result.append("EDGE_WEIGHT_TYPE : " + edgeWeightType + "\n");

        for (Node node : nodes) {
            result.append(node.toString() + "\n");
        }

        return result.toString();
    }
}
