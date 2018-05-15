package Modules;

import Actuators.Lightbulb;
import Actuators.PowerPlug;
import Exceptions.LightIntensityOutOfRangeException;
import Program.Room;
import Sensors.LightSensor;
import java.util.ArrayList;


public class LightControlModule extends Module {
    
    public LightControlModule(ArrayList<Room> rooms) {
        super(rooms);
    }
    
    public void switchLightsOfRoom(Room room, int intensity) {
        for(Room r : rooms) {
            if(r.equals(room)) {
                try {
                    r.setLightIntensity(intensity);
                } catch (LightIntensityOutOfRangeException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    
    @Override
    public void act(){
        for(Room r: rooms) {
        	LightSensor ls = r.getLightSensor();
                Lightbulb lb = r.getLightbulb();
                PowerPlug pp = r.getPowerPlug();
                if(ls != null && lb != null && pp != null) {
                    int idealLight = r.getIdealLight();
                    int curLight = ls.getLight();
                    if(curLight != idealLight) {
                        try {
                            r.setLightIntensity(idealLight);
                        } catch (LightIntensityOutOfRangeException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
        }
           
    }

    public void lightOn(){

    }
}
