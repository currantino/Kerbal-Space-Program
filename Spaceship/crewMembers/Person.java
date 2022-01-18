package Spaceship.crewMembers;

public class Person {

    public String name;
    int age;
    int height;
    int weight;

    public Person(String name, int age, int height, int weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void say(String saying){
        System.out.println(saying);
    }
}