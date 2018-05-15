package Media;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Video responsavel por guardar as informações dos videos gravados.
 *
 */
public class Video implements Serializable {

    private LocalDateTime dateTimeBeginRecord;
    private LocalDateTime dateTimeEndRecord;
    private int idRoom;

    public Video(int idRoom) {
        dateTimeBeginRecord = LocalDateTime.now();
        dateTimeEndRecord = dateTimeBeginRecord.plusMinutes(5);
        this.idRoom = idRoom;
    }

    public LocalDateTime getDateTimeBeginRecord() {
        return dateTimeBeginRecord;
    }

    public LocalDateTime getDateTimeEndRecord() {
        return dateTimeEndRecord;
    }

}
