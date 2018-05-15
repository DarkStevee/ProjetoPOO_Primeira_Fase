package Modules;

import Program.Room;
import java.util.ArrayList;


public class LightControlModule extends Module {
    
    public LightControlModule() {
        super();
    }
    
    public void addRooms(ArrayList<Room> rooms) {
        this.rooms.addAll(rooms);
    }
    
    @Override
    public void act(){
        for(Room r: rooms) {
        	
        }
           
    }

    public void lightOn(){

    }
}
