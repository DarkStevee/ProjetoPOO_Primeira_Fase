package Modules;

import Actuators.Alert;
import Actuators.PhotoCamera;
import Actuators.VideoCamera;
import Media.Photo;
import Media.SaveAndLoadFiles;
import Media.TypePhoto;
import Media.Video;
import Program.Room;
import Sensors.MovementSensor;
import Sensors.OpenDoorSensor;
import java.util.ArrayList;

public class AlarmControlModule extends Module {
    
    private OpenDoorSensor openDoorSensor;
    private MovementSensor movementSensor;
    private PhotoCamera photoCamera;
    private VideoCamera videoCamera;
    private Alert alarm;
    private int pin;
    
    public AlarmControlModule(int pin, ArrayList<Room> rooms) {
        super(rooms);
        this.pin = pin;        
    }
    
    public void intruderDetection() {
        if (openDoorSensor.getOpenDoor() || movementSensor.isMovement()) {
            ringAlert();
          //takeVideo();
          //takePhoto();
        }        
    }
    
    public void takePhoto(TypePhoto typePhoto, int idRoom) {
        Photo photo = new Photo(typePhoto, idRoom);
        photoCamera.savePhoto("", photo);
    }
    
    public void takeVideo(int idRoom) {
        Video video = new Video(idRoom);
        SaveAndLoadFiles.saveVideo("", video);
    }
    
    public void ringAlert() {
        alarm.changeVolume(10);
    }
    
    public void deactivateAlarm(int pin) {
        if (this.pin == pin) {
            alarm.changeVolume(0);
        }
    }
    
    @Override
    public void act() {
        
    }
    
}
