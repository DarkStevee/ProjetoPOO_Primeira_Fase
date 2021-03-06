package Actuators;

import Media.Photo;
import Media.SaveAndLoadFiles;
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

    /**
     *
     * Metodo para a persistencia de uma fotografia
     *
     * @param filename - nome do arquivo que sera salvo
     * @param typePhoto - o tipo da foto
     * @param idRoom - id da divisão onde a foto foi tirada
     * @throws IllegalArgumentException - Erro caso a persistencia seja incorreta
     */
    public void photoShoot(String filename, TypePhoto typePhoto, int idRoom) throws IllegalArgumentException {
        flash = true;
        Photo photo = new Photo(typePhoto, idRoom);
        SaveAndLoadFiles.savePhoto(filename, photo);
        flash = false;
    }

}
