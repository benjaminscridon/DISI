package model;

/**
 * Created by Beniamin on 3/31/2017.
 */
public class TspResult extends Tsp {

    private double cost;
    private long executionTime;

    public TspResult() {
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTotal cost: " + cost + "\nExecution Time: " + (executionTime / 1000) + " µs.";
    }
}
