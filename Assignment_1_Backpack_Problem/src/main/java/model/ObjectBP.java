package model;

import java.math.BigDecimal;

/**
 * 
 * @author Beniamin Scridon
 *
 */
public class ObjectBP {
	private int id;
	private int value;
	private int weight;

	public ObjectBP() {
	}

	public ObjectBP(int id, int value, int weight) {
		this.id = id;
		this.value = value;
		this.weight = weight;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "        [id=" + id + ", value=" + value + ", weight=" + weight + "]";
	}
}
