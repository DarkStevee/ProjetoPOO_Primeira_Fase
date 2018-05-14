/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Media;

import Exceptions.InvalidInput;
import java.time.LocalDateTime;

public class Video{

    private LocalDateTime dateTimeBeginRecord;
    private LocalDateTime dateTimeEndRecord;
    private int idRoom;

    public Video(int idRoom) throws InvalidInput {
        dateTimeBeginRecord = LocalDateTime.now();
        dateTimeEndRecord = dateTimeBeginRecord.plusMinutes(5);
        this.idRoom = idRoom;
    }
    

}
