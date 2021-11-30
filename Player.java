public class Player {

    private String name;
    private String sex;
    private String god;
    private int age;
    
    public static int playerNo = 0;

    public Player(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        playerNo++;
    }

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
