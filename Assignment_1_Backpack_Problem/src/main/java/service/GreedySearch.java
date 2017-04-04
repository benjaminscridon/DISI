package service;

import model.Backpack;
import model.BackpackProblem;
import model.ObjectBP;

import java.util.List;

/**
 * Created by Beniamin on 3/8/2017.
 */
public class GreedySearch {

    public Backpack computeSolution(BackpackProblem problem) {
        int maxWeight = problem.getMaxWeight();
        Backpack backpack = new Backpack();

        while (backpack.getWeight() < maxWeight && problem.getObjects().size() > 0) {
            ObjectBP current = getObjectWithMaximumValueWeightRatio(problem.getObjects());

            if (backpack.getWeight() + current.getWeight() < maxWeight) {
                backpack.getObjects().add(current);
                backpack.setWeight(backpack.getWeight() + current.getWeight());
                backpack.setValue(backpack.getValue() + current.getValue());
            }
            problem.getObjects().remove(current);
        }

        return backpack;
    }

    public ObjectBP getObjectWithMaximumValue(List<ObjectBP> objects) {
        ObjectBP object = new ObjectBP();

        for (ObjectBP o : objects) {
            if (object.getValue() < o.getValue()) {
                object = o;
            }
        }

        return object;
    }

    public ObjectBP getObjectWithMinimumWeight(List<ObjectBP> objects) {
        ObjectBP object = objects.get(0);

        for (int i = 1; i < objects.size(); i++) {
            if (object.getWeight() > objects.get(i).getWeight()) {
                object = objects.get(i);
            }
        }

        return object;
    }

    public ObjectBP getObjectWithMaximumValueWeightRatio(List<ObjectBP> objects) {
        ObjectBP object = objects.get(0);

        for (ObjectBP o : objects) {
            double a = (double) object.getValue() / (double) object.getWeight();
            double b = (double) o.getValue() / (double) o.getWeight();
            if (a < b) {
                object = o;
            }
        }

        return object;
    }
}
