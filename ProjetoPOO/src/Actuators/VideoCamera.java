package Actuators;

import Media.*;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Video camera que extend a classe de Atuadores Classe responsavel por tirar fotos e fazer gravações das divisões
 *
 */
public class VideoCamera extends Actuator {

    private final int RECORD = 5; //5 segundos
    private boolean flash;

    public VideoCamera() {
        super(null);
        flash = false;
    }

    /**
     * Metodo para persistencia de uma foto
     *
     * @param filename - nome do arquivo que sera salvo
     * @param typePhoto - tipo de foto que sera tirada, horinzontal ou vertical
     * @param idRoom - id da divisão onde a foto foi tirada
     * @throws IllegalArgumentException
     */
    void photoShoot(String filename, TypePhoto typePhoto, int idRoom) throws IllegalArgumentException {
        flash = true;
        Photo photo = new Photo(typePhoto, idRoom);
        SaveAndLoadFiles.savePhoto(filename, photo);
        flash = false;
    }

    /**
     * Metodo para a persistencia de um video
     *
     * @param filename - nome do arquivo que sera salvo
     * @param idRoom - id da divisão onde a foto foi tirada
     * @throws IllegalArgumentException
     */
    void videoRecord(String filename, int idRoom) throws IllegalArgumentException {
        Video video = new Video(idRoom);
        SaveAndLoadFiles.saveVideo(filename, video);
    }
}
