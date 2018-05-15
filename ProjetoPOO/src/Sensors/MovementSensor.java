package Sensors;

import Exceptions.MovementSensorNotOnException;
import Program.Identifier;

public class MovementSensor extends Sensor{
    
    private final Identifier identifier;
    private boolean isOn;
    private boolean movement;
    
    public MovementSensor() {
        identifier = new Identifier("Movement Sensor");
        movement = false;
        isOn = false;
    }  
    
    public boolean hasMovement() throws MovementSensorNotOnException {
    	if(isOn)
    		return isMovement();
        else throw new MovementSensorNotOnException("Turn movement sensor on first");
    }
    
    public void setMovement(boolean bool) {
    	if (isOn)
    		movement = bool;
    }
    
    public void changeState(boolean state) {
    	isOn = state;
    }
    
    
    
    public Identifier getIdentifier() {
        return identifier;
    }

    /**
     * @return the movement
     */
    public boolean isMovement() {
        return movement;
    }
}
