package Media;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Photo que é um objeto da foto tirada.
 *
 */
public class Photo implements Serializable {

    private TypePhoto typePhoto;
    private LocalDateTime dateTime;
    private int idRoom;

    public Photo(TypePhoto typePhoto, int idRoom) {
        this.typePhoto = typePhoto;
        dateTime = LocalDateTime.now();
        this.idRoom = idRoom;
    }
/**
 * 
 * @return a data que a foto foi retirada
 */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
