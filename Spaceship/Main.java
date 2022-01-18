package Spaceship;

import Spaceship.Parts.*;
import Spaceship.crewMembers.*;

public class Main {
    public static void main(String[] args){

        //Работа пакета crewMembers

        Astronaut JackHarlow = new Astronaut("Colonel", "Jack Harlow", 27,175,65, "Captain");
        Astronaut TravisScott = new Astronaut("Mayor", "Travis Scott", 29,180,70, "Mechanic");
        //Создание объекта анонимного класса
        Astronaut ye = new Astronaut("Nigga", "ye", 40, 190, 150, "Rapper"){
            @Override
            public void say(String rapSong){
                System.out.println(rapSong);
            }
        };
        String rapSong1 = "I'm representin' for them gangstas all across the world \nStill Hittin' them corners in them low-lows, girl \nStill takin' my time to perfect the beat \nAnd I still got love for the streets, it's the D.R.E. \n";

        SpaceShip.SpaceshipCrew crew1 = new SpaceShip.SpaceshipCrew("AstroRappers");
        crew1.addMember(JackHarlow);
        crew1.addMember(TravisScott);
        crew1.replaceMember(JackHarlow, ye);
        crew1.deleteMember(TravisScott);

        // Создание объектов - ракеты и двигателей

        Shuttle shuttle = new Shuttle("Orion", 11000, 1984);
        Rocket rocket = new Rocket("Soyuz", 5000, 2007);
        rocket.crew = crew1;
        // Симуляция полета
        System.out.println(rocket.crew);
        System.out.println("\n" + rocket + rocket.mainEngine + rocket.turningEngine + rocket.stoppingEngine + "\n\n");
        try{
            rocket.takeOff(rocket.mainEngine, rocket.turningEngine, rocket.stoppingEngine);
        }
        catch (EmptyShipException e){
            System.err.print(e + "\n");
            System.exit(0);
        }
        System.out.println("\n" + rocket + rocket.mainEngine + rocket.turningEngine + rocket.stoppingEngine + "\n\n");
        try{
            rocket.speedUp(400, rocket.mainEngine, rocket.stoppingEngine);
        } catch (EngineOverPowerException e) {
            System.err.println(e + "\n");
            ye.say(rapSong1);
            System.exit(0);
        }
        rocket.changeDirection(DIRECTIONS.RIGHT, rocket.turningEngine);
        System.out.println("\n" + rocket + rocket.mainEngine + rocket.turningEngine + rocket.stoppingEngine + "\n\n");
        rocket.slowDown(100 , rocket.mainEngine, rocket.stoppingEngine);
        System.out.println("\n" + rocket + rocket.mainEngine + rocket.turningEngine + rocket.stoppingEngine + "\n\n");

    }
}

