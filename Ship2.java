import java.util.ArrayList;
import java.util.List;

public class Ship2 {

    private char name;
    private int capacity;
    private int tolerance;
    private int x;
    private int y;
    private int size;
    private String direction;

    public Ship2(int x, int y, int size, String direction) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.direction = direction;
    }
    
    public Ship2() {

    }

    public int getCapacity() {
        return capacity;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getSize() {
        return size;
    }
    
    public String getDirection() {
        return direction;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTolerance() {
        return tolerance;
    }

    public void setTolerance(int tolerance) {
        this.tolerance = tolerance;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
}
