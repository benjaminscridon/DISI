package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Beniamin Scridon
 *
 */
public class Backpack {

	private int value;
	private int weight;
	private List<ObjectBP> objects;

	public Backpack() {
		value = 0;
		weight = 0;
		objects = new ArrayList<ObjectBP>();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<ObjectBP> getObjects() {
		return objects;
	}

	public void setObjects(List<ObjectBP> objects) {
		this.objects = objects;
	}

	public StringBuilder prettyPrint() {
		StringBuilder result = new StringBuilder();
		result.append("Number of objects=" + objects.size() + "\n");

		for (ObjectBP o : objects) {
			result.append(o.toString() + "\n");
		}

		result.append("Value=" + value + "\n");
		result.append("Weight=" + weight);
		return result;
	}

}
