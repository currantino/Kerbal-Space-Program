package Spaceship;

// Класс космического корабля типа "Rocket"

public class Rocket extends SpaceShip{

    public Rocket(String name, int maxSpeed, int yearOfConstruction) {
        super(name, maxSpeed, yearOfConstruction);
    }

    public String land(){
        return "Landing completed successfully!!";
    }

}

