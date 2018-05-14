/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actuators;

import Exceptions.InvalidInput;
import Media.Photo;
import Media.SaveAndLoadFiles;
import Media.TypePhoto;

/**
 *
 * @author eugenio
 */
public class PhotoCamera extends SaveAndLoadFiles {
    private boolean flash;
    private TypePhoto photoFormat;

    public PhotoCamera() {
        flash = false;
    }
    
    
    void photoShoot(String filename, TypePhoto typePhoto, int idRoom) throws InvalidInput {
        flash = true;
        Photo photo = new Photo(typePhoto, idRoom);
        savePhoto(filename, photo);
        flash = false;
    }
    
}
