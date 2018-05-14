/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Media;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author eugenio
 */
public class Photo implements Serializable{

    private TypePhoto typePhoto;
    private LocalDateTime dateTime;
    private int idRoom;

    public Photo(TypePhoto typePhoto, int idRoom){
        this.typePhoto = typePhoto;
        dateTime = LocalDateTime.now();
        this.idRoom = idRoom;
    }
    
    
    
}
