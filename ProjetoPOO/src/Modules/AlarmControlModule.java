package Modules;

import Actuators.Alert;
import Actuators.PhotoCamera;
import Actuators.VideoCamera;
import Sensors.MovementSensor;
import Sensors.OpenDoorSensor;

public class AlarmControlModule extends Module {
    
    private OpenDoorSensor openDoorSensor;
    private MovementSensor movementSensor;
    private PhotoCamera photoCamera;
    private VideoCamera videoCamera;
    private Alert alarm;
    private int pin;

    public void intruderDetection(){
        
    }

    public void takePhoto(){
        
    }

    public void takeVideo(){
        
    }

    public void ringAlert(){
        
    }

    public void deactivateAlarm(){
        
    }

    @Override
    public void act() {
        
    }

}
