package model;

import java.util.List;

/**
 * 
 * @author Beniamin Scridon
 *
 */
public class BackpackProblem {
	private int numberOfObjects;
	private List<ObjectBP> objects;
	private int maxWeight;

	public BackpackProblem() {
	}

	public BackpackProblem(int numberOfObjects, List<ObjectBP> objects, int maxWeight) {
		this.numberOfObjects = numberOfObjects;
		this.objects = objects;
		this.maxWeight = maxWeight;
	}

	public int getNumberOfObjects() {
		return numberOfObjects;
	}

	public void setNumberOfObjects(int objectsNumber) {
		this.numberOfObjects = objectsNumber;
	}

	public List<ObjectBP> getObjects() {
		return objects;
	}

	public void setObjects(List<ObjectBP> objects) {
		this.objects = objects;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public StringBuilder prettyPrint() {
		StringBuilder result = new StringBuilder();
		result.append("Number of objects=" + numberOfObjects + "\n");

		for (ObjectBP o : objects) {
			result.append(o.toString() + "\n");
		}

		result.append("Maximum weight=" + maxWeight);
		return result;
	}
}
