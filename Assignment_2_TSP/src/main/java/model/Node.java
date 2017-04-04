package model;

/**
 * Created by Beniamin on 3/30/2017.
 */
public class Node {

    private Integer index;
    private Integer x;
    private Integer y;
    private Integer visited;

    public Node() {
        this.visited = 0;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getVisited() {
        return visited;
    }

    public void setVisited(Integer visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return index + " " + x + " " + y;
    }
}
