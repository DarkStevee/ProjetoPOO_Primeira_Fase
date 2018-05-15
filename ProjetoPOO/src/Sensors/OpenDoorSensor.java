package Sensors;

import Program.Room;


public class OpenDoorSensor extends Sensor{
    
    private boolean openDoor;
    
    public OpenDoorSensor(Room room) {
        super(room);
        openDoor = false;
    }
    
    public void changeOpenDoorState(boolean state) {
        openDoor = state;
    }
    
    public boolean getOpenDoor() {
        return openDoor;
    }
}
