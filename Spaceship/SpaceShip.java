package Spaceship;

import Spaceship.Parts.*;
import Spaceship.crewMembers.Astronaut;
import Spaceship.crewMembers.DefaultCrew;
import Spaceship.crewMembers.Person;

import java.util.HashMap;

// Абстрактный класс-предок для всех космических кораблей

public abstract class SpaceShip implements Flying, AbleToChangeDirection {

    // Поля
    final int yearOfConstruction;
    int speed;
    final int maxSpeed;
    String name;
    DIRECTIONS dir = DIRECTIONS.FORWARD;
    SpaceshipCrew crew;
    MainEngine mainEngine = new MainEngine("main engine");
    StoppingEngine stoppingEngine = new StoppingEngine("stopping engine");
    TurningEngine turningEngine = new TurningEngine("turning engine");
    double timeInSpace;
    int distanceFromHomePlanet;

    // Конструктор

    public SpaceShip(String name, int maxSpeed, int yearOfConstruction) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.yearOfConstruction = yearOfConstruction;
    }

    // Присвоение имени объекту

    public void setName(String name) {
        this.name = name;
    }

    // Взлёт

    @Override
    public void takeOff(MainEngine mainEngine, TurningEngine turningEngine, StoppingEngine stoppingEngine) throws EmptyShipException {
        System.out.println("[Preparing takeoff]");
        if (this.crew == null || this.crew.crewNum < 1) {
            throw new EmptyShipException("Rocket is empty. Takeoff is impossible :/");
        }
        else{
            System.out.println("[Takeoff completed successfullly]");
        }
        speedUp(100, this.mainEngine, stoppingEngine);
        dir = DIRECTIONS.FORWARD;

    }

    // Ускорение ракеты

    public void speedUp(int increment, MainEngine mainEngine, StoppingEngine stoppingEngine) {
        stoppingEngine.stop();
        mainEngine.start();
        mainEngine.power += increment;
        speed += increment;
        if (speed > maxSpeed){
            throw new EngineOverPowerException("Engine is overpowered! We gonna die in the space :)");
        }
    }

    // Замедление ракеты

    public void slowDown(int decrement, MainEngine mainEngine, StoppingEngine stoppingEngine) {
        mainEngine.stop();
        stoppingEngine.start();
        stoppingEngine.power += decrement * 10;
        speed -= decrement;
        System.out.println("[Slowing Down completed successfully]");
    }

    // Смена направления ракеты

    @Override
    public void changeDirection(DIRECTIONS newDir, TurningEngine turningEngine) {
        this.dir = newDir;
        turningEngine.start();
        turningEngine.power = 250;
        if (newDir == DIRECTIONS.LEFT) turningEngine.setDirection(DIRECTIONS.RIGHT);
        if (newDir == DIRECTIONS.RIGHT) turningEngine.setDirection(DIRECTIONS.LEFT);
        turningEngine.power = 0;
        System.out.println("[Rotation completed successfully]");
    }

    // Запрос описания объекта

    @Override
    public String toString() {
        return ("\nSpaceShip's name: " + name + "\nSpeed: " + speed + "\nDirection: " + dir + "\n");
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        if (obj == null) return false;
        SpaceShip other = (SpaceShip) obj;
        return (this.maxSpeed == other.maxSpeed || this.name == other.name);
    }
    @Override
    public int hashCode(){
        int result;
        result = 11 + this.maxSpeed;
        result = 11 * result + this.yearOfConstruction;
        return result;
    }

    public static class MainEngine extends DefaultEngine {
        public MainEngine(String name) { super(name); }
    }

    public static class StoppingEngine extends DefaultEngine {

        public StoppingEngine(String name) {
            super(name);
        }
    }

    public static class TurningEngine extends DefaultEngine {

        DIRECTIONS dir;

        double angle;

        public TurningEngine(String name) {
            super(name);
        }

        // Установить направление

        public void setDirection(DIRECTIONS dir){
            this.dir = dir;
        }

        public void setAngle(double angle) {
            this.angle += angle;
        }

        @Override
        public String toString() {return ("\nEngine's name: " + name +  "\nEngine is running: " + isOn + "\nPower: " + power + "\nEngine Direction: " + dir + "\n");}

    }

    public static class SpaceshipCrew extends DefaultCrew {

        public SpaceshipCrew(String name) {super(name);}

        public HashMap<String, String> crewMembers = new HashMap();

        public void addMember(Astronaut a){
            crewMembers.put(a.name, a.role);
            crewNum += 1;
        }

        public void deleteMember(Person a){
            crewMembers.remove(a.name);
            crewNum -= 1;
        }

        public void replaceMember(Astronaut a, Astronaut newA){
                crewMembers.remove(a.name);
                crewMembers.put(newA.name, newA.role);
        }
        public boolean crewCheck(){
            if (this.crewNum > 1){
                System.out.println(this.crewNum);
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public String toString() {
            return this.name + "\n" + crewMembers.toString() + "\nNumber of astronauts: " + crewNum ;
        }
    }
}
