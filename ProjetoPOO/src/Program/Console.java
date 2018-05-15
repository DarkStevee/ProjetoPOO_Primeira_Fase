package Program;

import Exceptions.ParedException;
import Modules.*;
import java.util.ArrayList;

public class Console {

    private static int clientCounter = 0;

    private final String clientName;
    private final int clientNumber;
    private int pin;

    private ArrayList<Room> rooms;
    private Wifi wifiConnections;

    private LightControlModule lcm;
    private TemperatureControlModule tcm;
    private AlarmControlModule acm;

    public Console(String clientName) {
        this.clientName = clientName;
        this.clientNumber = ++clientCounter;
        wifiConnections = new Wifi();
        rooms = new ArrayList<>();
        
        initializeModules(rooms);
        pin = 1234;
        
        lcm = new LightControlModule(rooms);
        tcm = new TemperatureControlModule(rooms);
        acm = new AlarmControlModule(pin,rooms);

    }

    public void initializeModules(ArrayList<Room> roomsToAdd) {
        this.rooms = roomsToAdd;
    }

    public void addRoom(Room room) {
        try {
            rooms.add(room);
        } catch (NullPointerException ex) {
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
        return "Nome: " + clientName + " id: " + clientNumber;
    }

    public void act() {
        lcm.act();
        tcm.act();
        acm.act();
    }
}
