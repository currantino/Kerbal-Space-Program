package Spaceship;

import Spaceship.Parts.DIRECTIONS;

// Интерфейс с поведением любого космического корабля

public interface Flying {
    public void takeOff(SpaceShip.MainEngine mainEngine, SpaceShip.TurningEngine turningEngine, SpaceShip.StoppingEngine stoppingEngine) throws EmptyShipException;
    public void speedUp(int increment, SpaceShip.MainEngine mainEngine, SpaceShip.StoppingEngine stoppingEngine);
    public void slowDown(int decrement, SpaceShip.MainEngine mainEngine, SpaceShip.StoppingEngine stoppingEngine);
}
