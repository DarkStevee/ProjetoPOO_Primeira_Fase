package Modules;

import Actuators.Alert;
import Exceptions.MovementSensorNotOnException;
import Media.Photo;
import Media.SaveAndLoadFiles;
import Media.TypePhoto;
import Media.Video;
import Program.Room;
import java.util.Arrays;
import java.util.ArrayList;


public class AlarmControlModule extends Module {
    
    private Alert alert;
    
    public AlarmControlModule(ArrayList<Room> rooms, Alert alert) {
        super(rooms);
        this.alert = alert;    
    }
    
    public boolean intruderDetection(Room room) {
        try {
            if ((room.getOpenDoorSensor().getOpenDoor() || room.getMovementSensor().hasMovement()) && alert.getActivated()) {
                return true;       
            }
        } catch (MovementSensorNotOnException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public void takePhoto(TypePhoto typePhoto, int idRoom) {
        Photo photo = new Photo(typePhoto, idRoom);
        SaveAndLoadFiles.savePhoto("photo", photo);
    }
    
    public void takeVideo(int idRoom) {
        Video video = new Video(idRoom);
        SaveAndLoadFiles.saveVideo("video", video);
    }
    
    public void ringAlert() {
        alert.changeVolume(10);
    }
    
    public void setAlert(char[] pin, Room room) {
        if (Arrays.equals(pin, alert.getPin())) {
            alert.changeVolume(0);
        }
    }
    
    @Override
    public void act() {
        for(Room r : rooms) {
            if(intruderDetection(r)) {
                ringAlert();
                takeVideo(r.getId());
                takePhoto(TypePhoto.HORIZONTAL, r.getId()); 
            }
        }
    }
    
}
