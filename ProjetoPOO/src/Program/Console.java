package Program;

import java.util.ArrayList;

public class Console {
    private String clientName;
    private int clientNumber;
    private ArrayList<Room> rooms;
    private Wifi wifiConnections;

    public Console(String clientName, int clientNumber) {
        this.clientName = clientName;
        this.clientNumber = clientNumber;
        rooms = new ArrayList<>();
        wifiConnections = new Wifi();
    }
    
    void 
}
