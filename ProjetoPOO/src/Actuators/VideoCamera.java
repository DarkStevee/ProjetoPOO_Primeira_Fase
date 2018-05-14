package Actuators;

import Exceptions.InvalidInput;
import Media.Photo;
import Media.SaveAndLoadFiles;
import Media.TypePhoto;
import Media.Video;

public class VideoCamera extends SaveAndLoadFiles {

    private final int RECORD = 5; //5 segundos
    private boolean flash;

    public VideoCamera() {
        flash = false;
    }

    void photoShoot(String filename, TypePhoto typePhoto, int idRoom) throws InvalidInput {
        flash = true;
        Photo photo = new Photo(typePhoto, idRoom);
        savePhoto(filename, photo);
        flash = false;
    }

    void videoRecord(String filename, int idRoom) throws InvalidInput {
        Video video = new Video(idRoom);
        saveVideo(filename, video);
    }
}
