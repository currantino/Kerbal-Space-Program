package Spaceship.crewMembers;
public class Astronaut extends Person {

    String rank;
    String role;
    //int timeInSpace

    public Astronaut(String rank, String name, int age, int height, int weight, String role) {
        super(name, age, height, weight);
        this.rank = rank;
        this.role = role;
    }

}