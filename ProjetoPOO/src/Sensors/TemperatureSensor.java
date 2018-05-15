package Sensors;

import Actuators.PowerPlug;
import Exceptions.NotPluggedInException;
import Program.Room;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe responsavel pelo Sensor de temperatura, extent a classe Sensor
 *
 */
public class TemperatureSensor extends Sensor {

    private int temperature;
    private PowerPlug plug;

    public TemperatureSensor(PowerPlug plug, int temperature, Room room) {
        super(room);
        this.plug = plug;
        this.temperature = temperature;
    }

    public int getTemperature() throws NotPluggedInException {
        if (plug == null || !plug.isOn()) {
            throw new NotPluggedInException("The plug to this sensor is not plugged in or is off");
        } else {
            return temperature;
        }
    }

    public void setTemperature(int temperature) {
        if (plug.isOn() && temperature > 0) {
            this.temperature = temperature;
        }
    }
}
