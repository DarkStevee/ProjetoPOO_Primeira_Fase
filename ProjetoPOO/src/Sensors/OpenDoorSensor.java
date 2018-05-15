package Sensors;


public class OpenDoorSensor extends Sensor{
    
    private boolean openDoor;
    
    public OpenDoorSensor() {
        openDoor = false;
    }
    
    public void changeOpenDoorState(boolean state) {
        openDoor = state;
    }
    
    public boolean getOpenDoor() {
        return openDoor;
    }
}
