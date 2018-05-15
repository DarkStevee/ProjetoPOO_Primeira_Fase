package Modules;

import Actuators.Alert;
import Actuators.PhotoCamera;
import Actuators.VideoCamera;
import Media.Photo;
import Media.TypePhoto;
import Media.Video;
import Sensors.MovementSensor;
import Sensors.OpenDoorSensor;

public class AlarmControlModule extends Module {
    
    private OpenDoorSensor openDoorSensor;
    private MovementSensor movementSensor;
    private PhotoCamera photoCamera;
    private VideoCamera videoCamera;
    private Alert alarm;
    private int pin;
    
    public AlarmControlModule(int pin) {
        openDoorSensor = new OpenDoorSensor();
        movementSensor = new MovementSensor();
        photoCamera = new PhotoCamera();
        videoCamera = new VideoCamera();
        alarm = new Alert();
        this.pin = pin;        
    }

    public AlarmControlModule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        videoCamera.saveVideo("", video);
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
