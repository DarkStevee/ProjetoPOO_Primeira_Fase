package Sensors;


public class OpenDoorSensor extends Sensor{
    
    private boolean openDoor;
    
    public OpenDoorSensor() {
        openDoor = false;
    }
    
    public void setOpenDoor(Boolean bool) {
        openDoor = bool;
    }
    
    public boolean getOpenDoor() {
        return openDoor;
    }
}
