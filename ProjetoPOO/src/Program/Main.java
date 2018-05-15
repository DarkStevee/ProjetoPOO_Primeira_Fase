package Program;

import Actuators.*;
import Exceptions.NotPluggedInException;
import Exceptions.SensorNotImplomentedException;
import Sensors.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

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

        //adicionar a sala criada com os sensores e atuadores necessarios na consola
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(room);
        Console centralConsole = new Console("Teste", wifi, alert, rooms);
        centralConsole.addRoom(room);

        //modules sao criados quando criamos a consola mas necessitam dos sensores para funcionar
        //demonstracao, quando o plug nao esta ligado da uma mensagem de erro
        System.out.println("Erro:");
        try {
            room.getMovementSensor().changeState(true);
            centralConsole.act();
            System.out.println(centralConsole.toString());
            System.out.println(room.getTemperatureSensor().getTemperature());
        } catch (NotPluggedInException | SensorNotImplomentedException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            //apos ligarmos o plug pela consola
            System.out.println("Success:");
            centralConsole.setStateOfPlugOfRoom(room, true);
            try {
                room.getMovementSensor().changeState(true);
                centralConsole.act();
                System.out.println(centralConsole.toString());
                System.out.println(room.getTemperatureSensor().getTemperature());
            } catch (NotPluggedInException | SensorNotImplomentedException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (NotPluggedInException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
