package Program;

import Actuators.*;
import Exceptions.IncorrectPinException;
import Exceptions.NotPluggedInException;
import Exceptions.ParedException;
import Exceptions.SensorNotImplomentedException;
import Media.SaveAndLoadFiles;
import Sensors.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SaveAndLoadFiles.loadConsole("consola.bin"); // faz load da consola
        Wifi wifi = new Wifi("Casa");
        Alert alert = new Alert(1612);
        Room room = new Room(15, 2, 50);

        //inicializar os atuadores
        AirConditioning ac = new AirConditioning(room, 25);
        Lightbulb lb = new Lightbulb(room);
        PhotoCamera pc = new PhotoCamera();
        VideoCamera vc = new VideoCamera();
        PowerPlug plug = new PowerPlug(room);

        //inicializar os sensores
        LightSensor ls = new LightSensor(60, room);
        MovementSensor ms = new MovementSensor(room);
        OpenDoorSensor ods = new OpenDoorSensor(room);
        TemperatureSensor ts = new TemperatureSensor(plug, 21, room);

        //por os sensores numa certa sala
        room.setLightSensor(ls);
        room.setMovementSensor(ms);
        room.setOpenDoorSensor(ods);
        room.setTemperatureSensor(ts);

        //por atuadores necessarios na sala
        room.addAcToRoom(ac);
        room.addPowerPlugToRoom(plug);
        room.addLightbulbToRoom(lb);

        //adicionar a sala criada com os sensores e atuadores necessarios na consola
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(room);
        Console centralConsole = new Console("Teste", wifi, alert, rooms);
        centralConsole.addRoom(room);

        //modules sao criados quando criamos a consola mas necessitam dos sensores para funcionar
        //demonstracao, quando o plug nao esta ligado da uma mensagem de erro
        try {
            System.out.println("Initial luminosity to be compared at the end:");
            System.out.println(room.getCurrentLuminosity());

            System.out.println("Erro:");
            room.getMovementSensor().changeState(true);
            centralConsole.act();
            System.out.println(centralConsole.toString());
            System.out.println(room.getTemperatureSensor().getTemperature());
        } catch (NotPluggedInException | SensorNotImplomentedException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            //apos ligarmos o plug pela consola
            System.out.println("Error that the plug isnt connected to the wifi");
            centralConsole.setStateOfPlugOfRoom(room, true);
            try {
                room.getMovementSensor().changeState(true);
                centralConsole.act();
                System.out.println(centralConsole.toString());
                System.out.println(room.getTemperatureSensor().getTemperature());
            } catch (NotPluggedInException | SensorNotImplomentedException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (NotPluggedInException | IllegalArgumentException | ParedException ex) {
            System.out.println(ex.getMessage());
        }

        //sucesso com a connexao em wifi
        try {
            System.out.println("Success");
            centralConsole.addConnection(plug.getIdentifier(), centralConsole.getIdentifier(), "Casa");
            centralConsole.setStateOfPlugOfRoom(room, true);
            room.getMovementSensor().changeState(true); //precisamos de ligar este sensor para funcionar o act da consola
            centralConsole.act();
            System.out.println(centralConsole.toString());
            System.out.println(room.getTemperatureSensor().getTemperature());
        } catch (SensorNotImplomentedException | NotPluggedInException | IllegalArgumentException | ParedException ex) {
            System.out.println(ex.getMessage());
        }

        //teste na lightcontrol
        try {
            System.out.println("After the console being activated and the light has been controled:");
            System.out.println(room.getCurrentLuminosity());

        } catch (SensorNotImplomentedException ex) {
            System.out.println(ex.getMessage());
        }

        //teste da alarmcontrolmodule
        try {
            System.out.println("if alert rings, which it should since there has been an intruder, the volume must be at 10");
            centralConsole.changeActivatedWithPin(1612, true);
            ms.changeState(true); //a fingir que houve uma intrusao
            ms.setMovement(true);
            System.out.println("Intruder:");
            System.out.println(centralConsole.getAlert().getActivated());
            centralConsole.act();
            System.out.println("volume:");
            System.out.println(centralConsole.getAlert().getVolume());
        } catch (IncorrectPinException | SensorNotImplomentedException ex) {
            System.out.println(ex.getMessage());
        }

        //save and load
        System.out.println("saving the console");
        SaveAndLoadFiles.saveConsole("consola.bin", centralConsole); //faz saev da consola
    }
}
