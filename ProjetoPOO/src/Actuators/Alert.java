package Actuators;

import Program.Room;

public class Alert extends Actuator {

    public int alertVolume;// 0 e 10

    public Alert() {
        super(null);
        alertVolume = 0;
    }
    
   

    public void changeVolume(int alertVolume) throws IllegalArgumentException {
        if (alertVolume < 0 || alertVolume > 10) {
            throw new IllegalArgumentException("Volume is not valid");
        }
        this.alertVolume = alertVolume;
    }

}
