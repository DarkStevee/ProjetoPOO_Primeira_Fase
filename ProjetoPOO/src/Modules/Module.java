
package Modules;

import Program.Room;
import java.util.ArrayList;


public abstract class Module {

    protected ArrayList<Room> rooms;
    
    public Module(ArrayList<Room> consoleRoom) {
        rooms = consoleRoom;
    }

	public abstract void act();
    
}
