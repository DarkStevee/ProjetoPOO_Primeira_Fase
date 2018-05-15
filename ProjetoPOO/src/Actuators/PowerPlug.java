package Actuators;

import Program.Identifier;
import Program.Room;
import Sensors.TemperatureSensor;

import java.time.LocalTime;


public class PowerPlug extends Actuator {
    private Identifier plugId;
    private boolean on;
    private LocalTime internalTime;
    private Room room;
    
    private TemperatureSensor ts;  //unico pode estar ligado a tomada

    public PowerPlug(Room room) {
        super(room);
    	plugId = new Identifier("Plug");
        on = false;
        internalTime = null;
        
        ts = null;
        
    }
    
    public void connectTemperatureSensor(TemperatureSensor ts) {
    	this.ts = ts;
    }
    
    public void unplugSensor() {
    	ts = null;
    }

    public boolean isOn() {
        return on;
    }

    public void changeState(boolean state) {
        on = state;
    }
   
    public void turnOffAfterMinutes(long minutes) {
        if(minutes > 0 && internalTime == null) {
            internalTime = LocalTime.now().plusMinutes(minutes);
        }
        else {
            throw new IllegalArgumentException("Please insert minutes that are valid");
        }
    }
    
    public void turnOnAfterMinutes(long minutes) {
        if(minutes > 0 && internalTime == null) {
            internalTime = LocalTime.now().plusMinutes(minutes);
        }
        else {
            throw new IllegalArgumentException("Please insert minutes that are valid");
        }
    }
    
    public void act() {
        if(internalTime != null) {
            if(LocalTime.now().equals(internalTime)) {
                if(on) {
                    changeState(false);
                }
                else {
                    changeState(true);
                }
            }
        }
    }
}
