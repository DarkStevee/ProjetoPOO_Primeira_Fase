/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Media;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Video implements Serializable{

    private LocalDateTime dateTimeBeginRecord;
    private LocalDateTime dateTimeEndRecord;
    private int idRoom;

    public Video(int idRoom) {
        dateTimeBeginRecord = LocalDateTime.now();
        dateTimeEndRecord = dateTimeBeginRecord.plusMinutes(5);
        this.idRoom = idRoom;
    }
    

}
