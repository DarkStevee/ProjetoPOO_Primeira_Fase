package Actuators;

import Exceptions.LightIntensityOutOfRangeException;
import Program.Room;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Lampada extend a classe de Atuadores Classe responsavel
 * pela ativação/desativação das lampadas das divisões
 *
 */
public class Lightbulb extends Actuator {

    private int lightIntensity;
    private boolean onLightBulb;

    public Lightbulb(Room room) {
        super(room);
        lightIntensity = 0;
        onLightBulb = false;
    }

    /**
     * Metodo de ajuste da intensidade da iluminação
     *
     * @param lightIntensity
     * @throws LightIntensityOutOfRangeException
     */
    public void setLightIntensity(int lightIntensity) throws LightIntensityOutOfRangeException {
        if (lightIntensity >= 0 && lightIntensity <= 20) {
            if (!onLightBulb && lightIntensity > 0) {
                onLightBulb = true;
            } else if (onLightBulb && lightIntensity == 0) {
                onLightBulb = false;
            }
            this.lightIntensity = lightIntensity;
        } else {
            throw new LightIntensityOutOfRangeException("Light intensity is out of range.");
        }

    }

    public boolean isOn() {
        return onLightBulb;
    }

    public int getLightIntensity() {
        return lightIntensity;
    }

}
