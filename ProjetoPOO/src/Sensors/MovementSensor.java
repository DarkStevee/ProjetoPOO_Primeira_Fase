package Sensors;

import Exceptions.MovementSensorNotOnException;
import Program.Identifier;
import Program.Room;

public class MovementSensor extends Sensor{
    
    private final Identifier identifier;
    private boolean isOn;
    private boolean movement;
    
    public MovementSensor(Room room) {
        super(room);
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
