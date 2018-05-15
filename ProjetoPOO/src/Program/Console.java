package Program;

import Actuators.Alert;
import Exceptions.IncorrectPinException;
import Exceptions.ParedException;
import Modules.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Console {

    private static int clientCounter = 0;

    private final String clientName;
    private final int clientNumber;

    private ArrayList<Room> rooms;
    private Wifi wifiConnections;

    private LightControlModule lcm;
    private TemperatureControlModule tcm;
    private AlarmControlModule acm;
    
    private Alert alert;

    public Console(String clientName) {
        this.clientName = clientName;
        this.clientNumber = ++clientCounter;
        wifiConnections = new Wifi();
        rooms = new ArrayList<>();

        initializeModules(rooms);
        
        alert = new Alert(initializePin(1234));

        lcm = new LightControlModule(rooms);
        tcm = new TemperatureControlModule(rooms);
        acm = new AlarmControlModule(rooms, alert);

    }

    private char[] initializePin(int number) {
        char digit[] = new char[4];
        if (number > 999 && number < 10000) {// a 4 digit number 

            int i = 0;
            while (number > 0) {
                digit[i] = (char)(number % 10);
                number /= 10;
                i++;
            }
        }
        return digit;
    }
    
    public void setAlertVolume(int volume) {
        try {
            alert.changeVolume(volume);
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void changeActivatedWithPin(char[] pin, boolean change) throws IncorrectPinException {
        if(Arrays.equals(pin, alert.getPin())) {
            alert.changeActivated(change);
        } 
        else {
            throw new IncorrectPinException("Incorrect Pin");
        }
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
