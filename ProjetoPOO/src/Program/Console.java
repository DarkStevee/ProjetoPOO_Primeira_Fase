package Program;

import Actuators.Alert;
import Exceptions.IncorrectPinException;
import Exceptions.ParedException;
import Modules.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Console, classe de controle geral dos modulos
 *
 */
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

    /**
     * Construtor que inicializa todos dos modulos
     * @param clientName 
     */
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

    /**
     * Metodo que inicializa o Pin
     * @param number - senha que sera persistida no pin
     * @return - pin
     */
    private char[] initializePin(int number) {
        char digit[] = new char[4];
        if (number > 999 && number < 10000) {// a 4 digit number 

            int i = 0;
            while (number > 0) {
                digit[i] = (char) (number % 10);
                number /= 10;
                i++;
            }
        }
        return digit;
    }

    public void setAlertVolume(int volume) {
        try {
            alert.changeVolume(volume);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Metodo que permite desativar a sirene caso o pin seja correctamente digitado
     * @param pin - senha para validação
     * @param change
     * @throws IncorrectPinException 
     */
    public void changeActivatedWithPin(char[] pin, boolean change) throws IncorrectPinException {
        if (Arrays.equals(pin, alert.getPin())) {
            alert.changeActivated(change);
        } else {
            throw new IncorrectPinException("Incorrect Pin");
        }
    }

    public void initializeModules(ArrayList<Room> roomsToAdd) {
        this.rooms = roomsToAdd;
    }

    /**
     * Metodo para adicionar uma divisao ao array de divisoes
     * @param room 
     */
    public void addRoom(Room room) {
        try {
            rooms.add(room);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Metodo que adiciona um par de indentificadores ao wifi
     * @param identifier1
     * @param identifer2 
     */
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
    /**
     * Metodo de acionamento de todos os metodos da classe
     */
    public void act() {
        lcm.act();
        tcm.act();
        acm.act();
    }
}
