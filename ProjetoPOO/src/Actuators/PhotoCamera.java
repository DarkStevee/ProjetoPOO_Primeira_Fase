/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actuators;

import Media.Photo;
import Program.Room;
import Media.TypePhoto;

/**
 *
 * @author eugenio
 */
public class PhotoCamera extends Actuator {

    private boolean flash;
    private TypePhoto photoFormat;

    public PhotoCamera() {
        super(null);
        flash = false;
    }

    public void photoShoot(String filename, TypePhoto typePhoto, int idRoom) throws IllegalArgumentException {
        flash = true;
        Photo photo = new Photo(typePhoto, idRoom);
        savePhoto(filename, photo);
        flash = false;
    }

    public void savePhoto(String name, Photo photo) {

    }

}
