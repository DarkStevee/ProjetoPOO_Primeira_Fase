package Actuators;

import Program.Identifier;


public class PowerPlug extends Actuators {
    Identifier plugId;
    private int tempMinutes;

    public PowerPlug() {
        plugId = new Identifier("Plug");
    }


}
