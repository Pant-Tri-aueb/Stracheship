public class Ship2 {

    private char name;
    private int capacity;
    private int tolerance;

    public Ship2(char name, int capacity, int tolerance) {
        this.name = name;
        this.capacity = capacity;
        this.tolerance = tolerance;
    }

    public int getCapacity() {
        return capacity;
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
