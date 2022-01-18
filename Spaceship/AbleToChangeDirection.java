package Spaceship;

import Spaceship.Parts.DIRECTIONS;

public interface AbleToChangeDirection {
    public void changeDirection(DIRECTIONS newDirR, SpaceShip.TurningEngine turningEngine);

}
