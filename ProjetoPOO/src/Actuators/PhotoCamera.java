package Actuators;

import Media.Photo;
import Program.Room;
import Media.TypePhoto;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Camara fotografica que extend a classe de Atuadores
 * Classe responsavel por tirar fotos das divisões
 *
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

    /**
     * Metodo para persistencia de fotos.
     *
     * @param name - nome do ficheiro que ira ser salvo
     * @param photo - objeto que sera persistido
     */
    public void savePhoto(String name, Photo photo) {

    }

}
