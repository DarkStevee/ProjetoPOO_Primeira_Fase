package Modules;

import Actuators.Lightbulb;
import Actuators.PowerPlug;
import Exceptions.LightIntensityOutOfRangeException;
import Program.Room;
import Sensors.LightSensor;
import java.util.ArrayList;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe do modulo de controlo da luminosidade
 *
 */
public class LightControlModule extends Module {

    public LightControlModule(ArrayList<Room> rooms) {
        super(rooms);
    }

    /**
     * Metodo de controlo da luminosidade
     *
     * @param room
     * @param intensity - intensidade da luz
     */
    public void switchLightsOfRoom(Room room, int intensity) {
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
     * Metodo de acionamento de todos os metodos da classe
     */
    @Override
    public void act() {
        for (Room r : rooms) {
            LightSensor ls = r.getLightSensor();
            Lightbulb lb = r.getLightbulb();
            if (ls != null && lb != null) {
                int idealLight = r.getIdealLight();
                int curLight = ls.getLight();
                if (curLight != idealLight) {
                    try {
                        r.setLightIntensity(idealLight / 5);
                    } catch (LightIntensityOutOfRangeException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }

    }

}
