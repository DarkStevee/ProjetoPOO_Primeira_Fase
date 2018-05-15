package Sensors;

import Program.Room;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe responsavel pelo Sensor de abertura da porta, extent a classe
 * Sensor
 *
 */
public class OpenDoorSensor extends Sensor{
    
    private boolean openDoor;
    
    public OpenDoorSensor(Room room) {
        super(room);
        openDoor = false;
    }
    /**
     * Metodo para modificação do estado da porta
     * @param state 
     */
    public void changeOpenDoorState(boolean state) {
        openDoor = state;
    }
    
    public boolean getOpenDoor() {
        return openDoor;
    }
}
