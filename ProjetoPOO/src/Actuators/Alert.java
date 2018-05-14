package Actuators;

import Exceptions.InvalidInput;

public class Alert extends Actuators {

    public int alertVolume;// 0 e 10

    public Alert() {
        alertVolume = 0;
    }

    public void changeVolume(int alertVolume) throws InvalidInput {
        if (alertVolume < 0 || alertVolume > 10) {
            throw new InvalidInput("Volume is not valid");
        }
        this.alertVolume = alertVolume;
    }

}
