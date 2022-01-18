package Spaceship.crewMembers;

import java.util.HashMap;

public class SpaceshipCrew extends DefaultCrew {

    public SpaceshipCrew(String name) {super(name);}

    int crewNum = 0;

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
        if (crewNum < 1){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.name + "\n" + crewMembers.toString();
    }
}
