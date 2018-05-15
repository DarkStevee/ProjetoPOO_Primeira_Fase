package Modules;

import Actuators.Actuator;
import Actuators.Lightbulb;
import Actuators.PowerPlug;
import Program.Room;
import Sensors.LightSensor;
import Sensors.Sensor;
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
