package Media;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe responsavel por salvar e carregar as fotos e videos
 *
 */
public abstract class SaveAndLoadFiles implements Serializable {

    /**
     * Metodo responsavel por salvar os videos tirados pelas videoCameras
     *
     * @param filename - nome do arquivo que sera salvo
     * @param video - objeto que sera persistido
     */
    public static void saveVideo(String filename, Video video) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(video);
            out.close();
        } catch (IOException var4) {
            var4.getMessage();
        }
    }

    /**
     * Metodo responsavel por carregar os videos de um respectivo arquivo.
     *
     * @param filename - nome do arquivo que sera carregado
     * @return - video que foi carregado
     */
    public static Video loadVideo(String filename) {
        Video c = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            c = (Video) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException var4) {
            var4.getMessage();
        } catch (ClassNotFoundException var5) {
            var5.getMessage();
        }

        return c;
    }

    /**
     * Metodo responsavel por salvar as photos tiradas pelas cameras de fotos e
     * video cameras
     *
     * @param filename - nome do arquivo que sera salvo
     * @param photo - objeto que sera persistido
     */
    public static void savePhoto(String filename, Photo photo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(photo);
            out.close();
        } catch (IOException var4) {
            var4.getMessage();
        }
    }

    /**
     * Metodos para carregar fotos de um respectivo arquivo
     *
     * @param filename - nome do arquivo que sera carregado
     * @return - foto que foi carregada
     */
    public static Photo loadPhoto(String filename) {
        Photo c = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            c = (Photo) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException var4) {
            var4.getMessage();
        } catch (ClassNotFoundException var5) {
            var5.getMessage();
        }
        return c;
    }

}
