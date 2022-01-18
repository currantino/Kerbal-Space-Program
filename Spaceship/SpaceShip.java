package Spaceship;

import Spaceship.Parts.*;
import Spaceship.crewMembers.SpaceshipCrew;

// Абстрактный класс-предок для всех космических кораблей

public abstract class SpaceShip implements Flying {

    // Поля
    int yearOfConstruction;
    int speed;
    int maxSpeed;
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
        speedUp(100, this.mainEngine,turningEngine,stoppingEngine);
        changeDirection(DIRECTIONS.FORWARD, turningEngine);
            if (crew == null || crew.crewCheck()) {
                throw new EmptyShipException("Rocket is empty. Takeoff is impossible :/");
            }
    }

    // Ускорение ракеты

    public void speedUp(int increment, MainEngine mainEngine, TurningEngine turningEngine, StoppingEngine stoppingEngine) {
        stoppingEngine.stop();
        mainEngine.start();
        mainEngine.power += increment;
        speed += increment;
        if (speed > 10000){
            throw new EngineOverPowerException("Engine is overpowered! We gonna die in the space :)");
        }
    }

    // Замедление ракеты

    public void slowDown(int decrement, MainEngine mainEngine, StoppingEngine stoppingEngine) {
        mainEngine.stop();
        stoppingEngine.start();
        stoppingEngine.power += decrement * 10;
        speed -= decrement;
    }

    // Смена направления ракеты

    @Override
    public void changeDirection(DIRECTIONS newDir, TurningEngine turningEngine) {
        this.dir = newDir;
        turningEngine.start();
        turningEngine.power = 250;
        if (newDir == DIRECTIONS.LEFT) turningEngine.setDirection(DIRECTIONS.RIGHT);
        if (newDir == DIRECTIONS.RIGHT) turningEngine.setDirection(DIRECTIONS.LEFT);
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
}
