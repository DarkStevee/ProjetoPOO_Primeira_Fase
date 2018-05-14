package Program;

import Exceptions.ParedException;
import Modules.Module;
import java.util.HashSet;

public class Console {
    
    private static int clientCounter = 0;
    
    private final String clientName;
    private final int clientNumber;
    
    private HashSet<Room> rooms;
    private Wifi wifiConnections;
    private HashSet<Module> modules;

    public Console(String clientName) {
        this.clientName = clientName;
        this.clientNumber = ++clientCounter;
        wifiConnections = new Wifi();
        rooms = new HashSet<>();
    }
    
    public void addRoom(Room room) {
        try {
            rooms.add(room);
        }
        catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void addConnection(Identifier identifier1, Identifier identifer2) {
        try {
            wifiConnections.addConnection(identifier1, identifer2);
        } catch (NullPointerException | ParedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public String toString() {
        return clientName + clientNumber;
    }
    
}
