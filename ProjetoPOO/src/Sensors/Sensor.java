
package Sensors;

import Program.Room;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe abstrata Sensor, classe base para os outros sensores
 *
 */
public abstract class Sensor {
    protected Room room;
    
    public Sensor(Room room) {
        this.room = room;
    }
    
    public Room getRoom() {
        return room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }
    
}
