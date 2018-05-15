package Actuators;

import Media.Photo;
import Media.SaveAndLoadFiles;
import Media.TypePhoto;
import Media.Video;
import Program.Room;

public class VideoCamera extends Actuator {

    private final int RECORD = 5; //5 segundos
    private boolean flash;

    public VideoCamera(Room room) {
        super(room);
        flash = false;
    }

    void photoShoot(String filename, TypePhoto typePhoto, int idRoom) throws IllegalArgumentException{
        flash = true;
        Photo photo = new Photo(typePhoto, idRoom);
        SaveAndLoadFiles.savePhoto(filename, photo);
        flash = false;
    }

    void videoRecord(String filename, int idRoom) throws IllegalArgumentException {
        Video video = new Video(idRoom);
        SaveAndLoadFiles.saveVideo(filename, video);
    }
}
