package Program;

import Actuators.Alert;
import Actuators.PowerPlug;
import Exceptions.IncorrectPinException;
import Exceptions.LightIntensityOutOfRangeException;
import Exceptions.NotPluggedInException;
import Exceptions.ParedException;
import Exceptions.SensorNotImplomentedException;
import Modules.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Console, classe de controle geral dos modulos
 *
 */
public class Console implements Serializable {

    private static int clientCounter = 0;
    private final String clientName;
    private final int clientNumber;
    private ArrayList<Room> rooms;
    private Wifi wifiConnections;
    private LightControlModule lcm;
    private TemperatureControlModule tcm;
    private AlarmControlModule acm;
    private Alert alert;
    private Identifier wifiIdentifier;

    /**
     * Construtor que inicializa todos dos modulos
     *
     * @param clientName - Nome do cliente que sera registrado na consola
     * @param wifi - Objeto do wifi que ira ser responsavel pela conexão
     * @param alert - Objeto do alert
     * @param roomstoAdd - Array de divisões que sera controlado
     */
    public Console(String clientName, Wifi wifi, Alert alert, ArrayList<Room> roomstoAdd) {
        this.clientName = clientName;
        this.clientNumber = ++clientCounter;
        wifiConnections = wifi;
        rooms = roomstoAdd;
        wifiIdentifier = new Identifier("Consola");

        this.alert = alert;

        lcm = new LightControlModule(rooms);
        tcm = new TemperatureControlModule(rooms);
        acm = new AlarmControlModule(rooms, alert);
    }

    public Alert getAlert() {
        return alert;
    }

    public Identifier getIdentifier() {
        return wifiIdentifier;
    }

    /**
     * metodo que liga ou desliga as tomadas e todos os que estiverem com ela
     * acedida pela sala
     *
     * @param room
     * @param state
     * @throws NotPluggedInException
     * @throws IllegalArgumentException
     * @throws ParedException
     */
    public void setStateOfPlugOfRoom(Room room, boolean state) throws NotPluggedInException, IllegalArgumentException, ParedException {
        if (room != null) {
            if (wifiConnections.isPared(room.getPowerPlug().getIdentifier())) {
                PowerPlug plug = room.getPowerPlug();
                if (plug != null) {
                    plug.changeState(state);
                } else {
                    throw new NotPluggedInException("This plug doesnt exist");
                }
            } else {
                throw new ParedException("This plug is not pared with the wifi connections");
            }
        } else {
            throw new IllegalArgumentException("This room doesnt exist");
        }
    }

    /**
     * metodo que acede ao ar condicionado de uma divisão diretamente pelo
     * consola principal
     *
     * @param room
     * @param state
     * @throws IllegalArgumentException
     */
    public void setACOfRoom(Room room, boolean state) throws IllegalArgumentException {
        if (room == null) {
            throw new IllegalArgumentException("This room doesnt exist");
        }
        room.getAirConditioning().turnOnOrOff(state);
    }

    /**
     * metodo que acede a lampada de uma divisão diretamente pelo consola
     * principal
     *
     * @param room
     * @param intensity
     */
    public void setLightOfRoom(Room room, int intensity) {
        for (Room r : rooms) {
            if (r.equals(room)) {
                try {
                    r.setLightIntensity(intensity);
                } catch (LightIntensityOutOfRangeException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    /**
     * Metodo para setar o volume da sirene
     *
     * @param volume
     */
    public void setAlertVolume(int volume) {
        try {
            alert.changeVolume(volume);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Metodo que permite desativar a sirene caso o pin seja correctamente
     * digitado
     *
     * @param pin - senha para validação
     * @param change
     * @throws IncorrectPinException
     */
    public void changeActivatedWithPin(int pin, boolean change) throws IncorrectPinException { //terá que fornecer o pin correto e depois consegue mudar
        char[] pinArray = alert.initializePin(pin);
        if (Arrays.equals(pinArray, alert.getPin())) {
            alert.changeActivated(change);
        } else {
            throw new IncorrectPinException("Incorrect Pin");
        }
    }

    /**
     * Metodo para adicionar uma divisao ao array de divisoes
     *
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
     *
     * @param identifier1
     * @param identifer2
     * @param password
     * @throws Exceptions.ParedException
     */
    public void addConnection(Identifier identifier1, Identifier identifer2, String password) throws IllegalArgumentException, NullPointerException, ParedException {
        if (password.equals(wifiConnections.getPassword())) {
            wifiConnections.addConnection(identifier1, identifer2);
        } else {
            throw new IllegalArgumentException("The password isnt correct");
        }
    }

    @Override
    public String toString() {
        return "Nome: " + clientName + " id: " + clientNumber;
    }

    /**
     * Metodo de acionamento de todos os metodos da classe
     *
     * @throws Exceptions.SensorNotImplomentedException
     */
    public void act() throws SensorNotImplomentedException {
        if (lcm != null && tcm != null && acm != null) {
            lcm.act();
            tcm.act();
            acm.act();
        } else {
            throw new SensorNotImplomentedException("A sensor is not implomented");
        }
    }
}
