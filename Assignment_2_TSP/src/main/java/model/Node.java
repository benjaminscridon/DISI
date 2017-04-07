package model;

/**
 * Created by Beniamin on 3/30/2017.
 */
public class Node {

    private int index;
    private double x;
    private double y;
    private int visited;

    public Node() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return index + " " + x + " " + y;
    }
}
