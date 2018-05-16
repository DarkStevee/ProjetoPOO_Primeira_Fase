package Modules;

import Actuators.AirConditioning;
import Exceptions.NotPluggedInException;
import Exceptions.SensorNotImplomentedException;
import Program.Room;
import Sensors.TemperatureSensor;
import java.util.ArrayList;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe do modulo de controlo da temperatura
 *
 */
public class TemperatureControlModule extends Module {

    public TemperatureControlModule(ArrayList<Room> rooms) {
        super(rooms);
    }

    public void addRooms(ArrayList<Room> rooms) {
        this.rooms.addAll(rooms);
    }

    /**
     * Metodo de acionamento de todos os metodos da classe
     */
    @Override
    public void act() {
        for (Room r : rooms) {
            TemperatureSensor ts = r.getTemperatureSensor();
            AirConditioning ac = r.getAirConditioning();

            if (ts != null && ac != null) {
                int idealTemp = r.getIdealTemperature();
                int intv = r.getInterval();
                int curTemp;
                try {
                    try {
                        curTemp = r.getCurrentTemperature();
                        if (curTemp > intv + idealTemp || curTemp < idealTemp - intv) {
                            r.setTemperature(r.getIdealTemperature());
                        }
                    } catch (SensorNotImplomentedException ex) {
                        System.out.println(ex.getMessage());
                    }
                } catch (NotPluggedInException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
