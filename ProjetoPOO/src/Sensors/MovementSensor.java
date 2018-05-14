package Sensors;

import Program.Identifier;

public class MovementSensor extends Sensor{
    
    private final Identifier identifier;
    private boolean movement;
    
    public MovementSensor() {
        identifier = new Identifier("Movement Sensor");
        movement = false;
    }  
    
    public boolean hasMovement() {
        return movement;
    }
    
    public void setMovement(Boolean bool) {
        movement = bool;
    }
    
    public Identifier getIdentifier() {
        return identifier;
    }
}
