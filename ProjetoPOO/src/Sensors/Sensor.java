package Sensors;

import Program.Room;
import java.io.Serializable;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe abstrata Sensor, classe base para os outros sensores
 *
 */
public abstract class Sensor implements Serializable{

    protected Room room;

    public Sensor(Room room) {
        this.room = room;
    }
/**
 * 
 * @return a divisão que está atuando
 */
    public Room getRoom() {
        return room;
    }
/**
 * seta a divisão que atuara
 * @param room 
 */
    public void setRoom(Room room) {
        this.room = room;
    }

}
