package Actuators;

import Program.Identifier;
import java.time.LocalTime;


public class PowerPlug extends Actuator {
    private Identifier plugId;
    private boolean on;
    private LocalTime internalTime;

    public PowerPlug() {
        plugId = new Identifier("Plug");
        on = false;
        internalTime = null;
    }

    public boolean isOn() {
        return on;
    }

    public void turnOff() {
        on = false;
    }
    
    public void turnOn() {
        on = true;
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
                    turnOff();
                }
                else {
                    turnOn();
                }
            }
        }
    }
}
