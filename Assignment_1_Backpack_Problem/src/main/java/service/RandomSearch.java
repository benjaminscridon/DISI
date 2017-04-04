package service;

import java.util.Random;
import model.Backpack;
import model.BackpackProblem;
import model.ObjectBP;

/**
 * 
 * @author Beniamin Scridon
 *
 */
public class RandomSearch {

	public Backpack computeSolution(BackpackProblem problem) {
		Backpack backpack = new Backpack();
		Random random = new Random();

		while (problem.getObjects().size() > 0) {
			int randomPos = random.nextInt(problem.getObjects().size());

			ObjectBP object = problem.getObjects().get(randomPos);
			if (backpack.getWeight() + object.getWeight() <= problem.getMaxWeight()) {
				updateBackpack(backpack, object);
				problem.getObjects().remove(object);
			}
			problem.getObjects().remove(object);
		}

		return backpack;
	}

	private void updateBackpack(Backpack backpack, ObjectBP object) {
		backpack.setWeight(backpack.getWeight() + object.getWeight());
		backpack.setValue(backpack.getValue() + object.getValue());

		backpack.getObjects().add(object);
	}
}
