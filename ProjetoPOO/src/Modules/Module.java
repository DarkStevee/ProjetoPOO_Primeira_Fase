package Modules;

import Program.Room;
import java.util.ArrayList;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe abstrata Modulo que tera as informações importantes para todos os outros modulos
 *
 */
public abstract class Module {

    protected ArrayList<Room> rooms;

    public Module(ArrayList<Room> consoleRoom) {
        rooms = consoleRoom;
    }

    public abstract void act();

}
