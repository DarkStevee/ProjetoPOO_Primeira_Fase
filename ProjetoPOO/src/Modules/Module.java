
package Modules;

import Program.Room;
import java.util.ArrayList;


public abstract class Module {

    protected ArrayList<Room> rooms;
    
    public Module() {
        rooms = new ArrayList<>();
    }

	/**
	 * 
	 */
	public abstract void act();
    
}
