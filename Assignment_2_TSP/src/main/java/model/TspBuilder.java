package model;

/**
 * Created by Beniamin on 4/6/2017.
 */
public class TspBuilder {

    public static void constructHeader(TspProblem tspProblem, TspResult tspResult) {
        tspResult.setName(tspProblem.getName());
        tspResult.setComment(tspProblem.getComment());
        tspResult.setDimension(tspProblem.getDimension());
        tspResult.setEdgeWeightType(tspProblem.getEdgeWeightType());
        tspResult.setType(tspProblem.getType());
    }
}
