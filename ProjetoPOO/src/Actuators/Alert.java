package Actuators;

public class Alert extends Actuator {

    private int alertVolume;// 0 e 10
    private boolean activated;
    private char[] pin;

    public Alert(char[] pin) {
        super(null);
        alertVolume = 0;
        activated = false;
        this.pin = pin;
    }

    public void changeVolume(int alertVolume) throws IllegalArgumentException {
        if (alertVolume < 0 || alertVolume > 10) {
            throw new IllegalArgumentException("Volume is not valid");
        }
        this.alertVolume = alertVolume;
    }
    
    public void changeActivated(boolean change) {
        activated = change;
    }
    
    public boolean getActivated() {
        return activated;
    }
    
    public char[] getPin() {
        return pin;
    }

}
