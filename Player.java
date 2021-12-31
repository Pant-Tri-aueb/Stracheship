// Class for each player
public class Player {
    
	// Player Data
    private String name;
    private String sex; // input String: male/female
    private String god =""; // initialized to avoid NullPointerExceptions
    private int age;
    
    // 1st or 2nd player
    public static int playerNo = 0;
    
    // Constructor
    public Player(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        playerNo++;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGod(String god) {
    	this.god = god;
    }
    
    public String getGod() {
    	return this.god;
    }
}
