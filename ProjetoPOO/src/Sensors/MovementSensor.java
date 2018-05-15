package Sensors;

import Exceptions.MovementSensorNotOnException;
import Program.Identifier;
import Program.Room;
/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe responsavel pelo Sensor de movimento, extent a classe
 * Sensor
 *
 */
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
    /**
     * Metodo de verificação se na divisão há movimento
     * @return
     * @throws MovementSensorNotOnException 
     */
    public boolean hasMovement() throws MovementSensorNotOnException {
    	if(isOn)
    		return movement;
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
}
