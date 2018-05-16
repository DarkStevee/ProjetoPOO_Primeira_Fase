package Sensors;

import Program.Room;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe responsavel pelo Sensor de iluminação, extent a classe Sensor
 *
 */
public class LightSensor extends Sensor{

    private int light;

    public LightSensor(int initialLight, Room room) {
        super(room);
        light = initialLight;
    }

    public int getLight() {
        return light;
    }

    /**
     * Metodo que modifica a luminosidade do ambiente entre 0 e 100%
     *
     * @param light - o valor entre 0 e 100 da lampada
     * @throws IllegalArgumentException
     */
    public void setLight(int light) throws IllegalArgumentException {
        if (light < 0 || light > 100) {
            throw new IllegalArgumentException("Light has to be between 0 and 100");
        }
        this.light = light;
    }
}
