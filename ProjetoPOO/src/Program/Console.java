package Program;

import Exceptions.ParedException;
import java.util.ArrayList;

public class Console {
    
    private static int clientCounter = 0;
    
    private String clientName;
    private final int clientNumber;
    private ArrayList<Room> rooms;
    private Wifi wifiConnections;

    public Console(String clientName) {
        this.clientName = clientName;
        this.clientNumber = ++clientCounter;
        rooms = new ArrayList<>();
        wifiConnections = new Wifi();
    }
    
    public void addConnection(Identifier identifier1, Identifier identifer2) {
        try {
            wifiConnections.addConnection(identifier1, identifer2);
        } catch (NullPointerException | ParedException ex) {
            ex.getMessage();
        }
    }
    
    @Override
    public String toString() {
        return clientName;
    }
}
