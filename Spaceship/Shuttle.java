package Spaceship;

// Класс космического корабля типа " Shuttle"

public class Shuttle extends Spaceship.SpaceShip {
    public Shuttle(String name, int maxSpeed, int yearOfConstruction){
        super(name, maxSpeed, yearOfConstruction);
    }

    public String dock(SpaceShip spaceShip){
        return "Docking with " + spaceShip.name + " completed successfully!!";
    };
}
