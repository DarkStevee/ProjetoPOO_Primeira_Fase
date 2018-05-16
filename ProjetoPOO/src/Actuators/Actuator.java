package Actuators;

import Program.Room;
import java.io.Serializable;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe abstrata padrão para base dos atuadores.
 *
 */
public abstract class Actuator implements Serializable{

    protected Room room;

    public Actuator(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
