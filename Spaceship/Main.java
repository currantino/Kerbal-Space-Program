package Spaceship;

import Spaceship.Parts.*;
import Spaceship.crewMembers.*;

public class Main {
    public static void main(String[] args){

        //Работа пакета crewMembers

        Astronaut JackHarlow = new Astronaut("Colonel", "Jack Harlow", 27,175,65, "Captain");
        Astronaut TravisScott = new Astronaut("Mayor", "Travis Scott", 29,180,70, "Mechanic");
        Astronaut ye = new Astronaut("Nigga", "ye", 40, 190, 150, "Rapper");

        SpaceshipCrew crew1 = new SpaceshipCrew("Niggas in da space");
        crew1.addMember(JackHarlow);
        crew1.addMember(TravisScott);
        crew1.replaceMember(JackHarlow, ye);
        crew1.deleteMember(TravisScott);
        crew1.toString();
        // Создание объектов - ракеты и двигателей

        Shuttle shuttle = new Shuttle("Orion", 11000, 1984);
        Rocket rocket = new Rocket("Soyuz", 5000, 2007);
        rocket.crew = crew1;
        //shuttle.crew = crew1;
        // Симуляция полета

        System.out.println("\n[Preparing takeoff...]\n" + rocket + rocket.mainEngine + rocket.turningEngine + rocket.stoppingEngine + "\n\n");
        try{
            shuttle.takeOff(rocket.mainEngine, rocket.turningEngine, rocket.stoppingEngine);
        }
        catch (EmptyShipException e){
            System.err.print(e + "\n");
        }
        System.out.println("[Takeoff completed successfully]\n" + rocket + rocket.mainEngine + rocket.turningEngine + rocket.stoppingEngine + "\n\n");
        rocket.changeDirection(DIRECTIONS.RIGHT, rocket.turningEngine);
        System.out.println("[Rotation completed successfully]\n" + rocket + rocket.mainEngine + rocket.turningEngine + rocket.stoppingEngine + "\n\n");
        rocket.slowDown(500, rocket.mainEngine, rocket.stoppingEngine);
        System.out.println("[Slowing Down completed successfully]\n" + rocket + rocket.mainEngine + rocket.turningEngine + rocket.stoppingEngine + "\n\n");
        try{
            rocket.speedUp(100000, rocket.mainEngine, rocket.turningEngine, rocket.stoppingEngine);
        } catch (EngineOverPowerException e) {
            System.err.println(e + "\n");
        }

    }
}

