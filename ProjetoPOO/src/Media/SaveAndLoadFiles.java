
package Media;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class SaveAndLoadFiles implements Serializable{    
   public static void saveVideo(String filename, Video video){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(video);
            out.close();
        } catch (IOException var4) {
            var4.getMessage();
        }
    }
    public static Video loadVideo(String filename){
        Video c = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            c = (Video)in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException var4) {
            var4.getMessage();
        } catch (ClassNotFoundException var5) {
            var5.getMessage();
        }

        return c;
    }
   public static void savePhoto(String filename, Photo photo){
         try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(photo);
            out.close();
        } catch (IOException var4) {
            var4.getMessage();
        }
    }
   public static Photo loadPhoto(String filename){
        Photo c = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            c = (Photo)in.readObject();
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
