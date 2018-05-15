package Actuators;

import Exceptions.LightIntensityOutOfRangeException;
import Program.Room;

public class Lightbulb extends Actuator {

    private int lightIntensity;
    private boolean onLightBulb;

    public Lightbulb(Room room) {
        super(room);
        lightIntensity = 0;
        onLightBulb = false;
    }

    public void adjustLightIntensity(int lightIntensity) throws IllegalArgumentException {
        if (lightIntensity < 0 || lightIntensity > 20) {
            throw new IllegalArgumentException("Light intensity is not valid");
        }
        this.lightIntensity = lightIntensity;
        onLightBulb = (lightIntensity > 0);
    }

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
